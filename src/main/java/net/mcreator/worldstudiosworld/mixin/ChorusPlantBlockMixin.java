package net.mcreator.worldstudiosworld.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModBlocks;

@Mixin(ChorusPlantBlock.class)
public abstract class ChorusPlantBlockMixin extends PipeBlock {
	public ChorusPlantBlockMixin(Properties settings) {
		super(0.3125F, settings);
	}

	@Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
	private void canSurvive(BlockState state, LevelReader world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
		BlockState blockstate = world.getBlockState(pos.below());
		if (blockstate.is(WorldstudiosWorldModBlocks.END_NEZIUM_ORE.get()) || blockstate.is(WorldstudiosWorldModBlocks.HALFSTONE.get()) || blockstate.is(Blocks.END_STONE)) {
			info.setReturnValue(true);
		}
	}

	@Inject(method = "getStateForPlacement(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/level/block/state/BlockState;", at = @At("RETURN"), cancellable = true)
	private void getStateForPlacement(BlockPlaceContext ctx, CallbackInfoReturnable<BlockState> info) {
		BlockPos pos = ctx.getClickedPos();
		Level world = ctx.getLevel();
		BlockState plant = info.getReturnValue();
		BlockState blockstate = world.getBlockState(pos.below());
		if (ctx.canPlace() && (plant.is(Blocks.CHORUS_PLANT) || plant.is(Blocks.CHORUS_FLOWER))
				&& (blockstate.is(WorldstudiosWorldModBlocks.END_NEZIUM_ORE.get()) || blockstate.is(WorldstudiosWorldModBlocks.HALFSTONE.get()) || blockstate.is(Blocks.END_STONE))) {
			info.setReturnValue(plant.setValue(BlockStateProperties.DOWN, true));
		}
	}

	@Inject(method = "getStateWithConnections", at = @At("HEAD"), cancellable = true)
	private static void getStateWithConnections(BlockGetter p_51711_, BlockPos p_51712_, BlockState p_304771_, CallbackInfoReturnable<BlockState> cir) {
		BlockState blockstate = p_51711_.getBlockState(p_51712_.below());
		Block block = p_304771_.getBlock();
		boolean flag = blockstate.is(WorldstudiosWorldModBlocks.END_NEZIUM_ORE.get()) || blockstate.is(WorldstudiosWorldModBlocks.HALFSTONE.get()) || blockstate.is(block) || blockstate.is(Blocks.CHORUS_FLOWER) || blockstate.is(Blocks.END_STONE);
		if (flag) {
			BlockState blockstate1 = p_51711_.getBlockState(p_51712_.above());
			BlockState blockstate2 = p_51711_.getBlockState(p_51712_.north());
			BlockState blockstate3 = p_51711_.getBlockState(p_51712_.east());
			BlockState blockstate4 = p_51711_.getBlockState(p_51712_.south());
			BlockState blockstate5 = p_51711_.getBlockState(p_51712_.west());
			var soilDecision = blockstate.canSustainPlant(p_51711_, p_51712_.below(), Direction.UP, p_304771_);
			cir.setReturnValue(p_304771_.trySetValue(DOWN, Boolean.valueOf(flag || soilDecision.isTrue())).trySetValue(UP, Boolean.valueOf(blockstate1.is(block) || blockstate1.is(Blocks.CHORUS_FLOWER)))
					.trySetValue(NORTH, Boolean.valueOf(blockstate2.is(block) || blockstate2.is(Blocks.CHORUS_FLOWER))).trySetValue(EAST, Boolean.valueOf(blockstate3.is(block) || blockstate3.is(Blocks.CHORUS_FLOWER)))
					.trySetValue(SOUTH, Boolean.valueOf(blockstate4.is(block) || blockstate4.is(Blocks.CHORUS_FLOWER))).trySetValue(WEST, Boolean.valueOf(blockstate5.is(block) || blockstate5.is(Blocks.CHORUS_FLOWER))));
		}
	}
}