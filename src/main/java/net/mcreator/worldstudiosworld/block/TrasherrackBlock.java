package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TrasherrackBlock extends Block {
	public TrasherrackBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHERRACK).strength(0.7f, 5.2f).requiresCorrectToolForDrops().speedFactor(1.1f).instrument(NoteBlockInstrument.GUITAR));
	}
}