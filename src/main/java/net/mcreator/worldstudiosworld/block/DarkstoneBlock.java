package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class DarkstoneBlock extends Block {
	public DarkstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BLACK).strength(4f, 20f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}