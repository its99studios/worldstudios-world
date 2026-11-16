package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class MuddyDarkstoneBlock extends Block {
	public MuddyDarkstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.WOOD).sound(SoundType.MUDDY_MANGROVE_ROOTS).strength(5f, 22f).requiresCorrectToolForDrops().friction(0.8f).instrument(NoteBlockInstrument.BASEDRUM));
	}
}