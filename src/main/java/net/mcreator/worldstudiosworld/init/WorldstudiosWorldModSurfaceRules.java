package net.mcreator.worldstudiosworld.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;

import net.mcreator.worldstudiosworld.mixin.NoiseGeneratorSettingsAccess;

import java.lang.reflect.Field;

@EventBusSubscriber
public class WorldstudiosWorldModSurfaceRules {
	@SubscribeEvent
	public static void init(ServerAboutToStartEvent event) {
		LevelStem levelStem = event.getServer().registryAccess().lookupOrThrow(Registries.LEVEL_STEM).getValue(LevelStem.END);
		ChunkGenerator chunkGenerator = levelStem.generator();
		boolean hasEndBiomes = chunkGenerator.getBiomeSource().possibleBiomes().stream().anyMatch(biomeHolder -> biomeHolder.unwrapKey().orElseThrow().identifier().getNamespace().equals("worldstudios_world"));
		if (hasEndBiomes) {
			if (chunkGenerator instanceof NoiseBasedChunkGenerator generator) {
				NoiseGeneratorSettings noiseGeneratorSettings = null;
				try {
					Field settingsField = NoiseBasedChunkGenerator.class.getDeclaredField("settings");
					settingsField.setAccessible(true);
					noiseGeneratorSettings = ((Holder<NoiseGeneratorSettings>) settingsField.get(generator)).value();
				} catch (Exception e) {
					e.printStackTrace();
				}
				registerSurfaceRules(Identifier.parse("worldstudios_world:voidlands"), noiseGeneratorSettings, Blocks.END_STONE.defaultBlockState(), WorldstudiosWorldModBlocks.VOIDED_END_STONE.get().defaultBlockState());
			}
		}
	}

	public static void registerSurfaceRules(Identifier biome, NoiseGeneratorSettings noiseGeneratorSettings, BlockState groundBlock, BlockState undergroundBlock) {
		((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).addSurfaceRule(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registries.BIOME, biome)),
				SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(groundBlock)), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(undergroundBlock)))), noiseGeneratorSettings.surfaceRule()));
	}
}