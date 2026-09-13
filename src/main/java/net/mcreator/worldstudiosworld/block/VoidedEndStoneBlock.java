package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class VoidedEndStoneBlock extends Block {
	public VoidedEndStoneBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_GRAY).strength(3f, 9f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}