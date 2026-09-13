package net.mcreator.worldstudiosworld.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.worldstudiosworld.endbiomes.TheEndBiomes;

@EventBusSubscriber
public class WorldstudiosWorldModEndBiomes {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheEndBiomes.addHighlandsBiome(ResourceKey.create(Registries.BIOME, Identifier.parse("worldstudios_world:voidlands")), 1d);
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, Identifier.parse("worldstudios_world:voidlands")), ResourceKey.create(Registries.BIOME, Identifier.parse("worldstudios_world:voidlands")), 1d);
		});
	}
}