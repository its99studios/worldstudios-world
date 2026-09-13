package net.mcreator.worldstudiosworld.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;

public class VoidBlockBlock extends Block {
	public VoidBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BLACK)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("worldstudios_world:void_block.idle")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("worldstudios_world:void_block.short")), () -> BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("worldstudios_world:void_block.idle")),
						() -> BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("worldstudios_world:void_block.short")), () -> BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("worldstudios_world:void_block.short"))))
				.strength(20f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.DRAGON));
	}

	@Override
	public int getLightDampening(BlockState state) {
		return 15;
	}
}