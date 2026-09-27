package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModWoodTypes;
import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModBlocks;

public class ChorusWallSignBlock extends WallSignBlock {
	public ChorusWallSignBlock(BlockBehaviour.Properties properties) {
		super(WorldstudiosWorldModWoodTypes.CHORUS_SIGN_WOOD_TYPE, properties.sound(SoundType.WOOD).strength(1.75f).noCollision().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn()
				.overrideLootTable(WorldstudiosWorldModBlocks.CHORUS_SIGN.get().getLootTable()).overrideDescription(WorldstudiosWorldModBlocks.CHORUS_SIGN.get().getDescriptionId()));
	}
}