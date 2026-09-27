package net.mcreator.worldstudiosworld.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.SoundType;

import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModWoodTypes;
import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModBlocks;

public class ChorusWallHangingSignBlock extends WallHangingSignBlock {
	public ChorusWallHangingSignBlock(BlockBehaviour.Properties properties) {
		super(WorldstudiosWorldModWoodTypes.CHORUS_HANGING_SIGN_WOOD_TYPE, properties.sound(SoundType.HANGING_SIGN).strength(1.75f).noCollision().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn()
				.overrideLootTable(WorldstudiosWorldModBlocks.CHORUS_HANGING_SIGN.get().getLootTable()).overrideDescription(WorldstudiosWorldModBlocks.CHORUS_HANGING_SIGN.get().getDescriptionId()));
	}
}