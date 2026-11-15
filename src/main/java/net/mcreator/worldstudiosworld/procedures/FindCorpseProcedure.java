package net.mcreator.worldstudiosworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.worldstudiosworld.entity.CorpseEntity;

import java.util.Comparator;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class FindCorpseProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double corpse_distance = 0;
		Entity desired_player = null;
		desired_player = commandParameterEntity(arguments, "player");
		if (!world.getEntitiesOfClass(CorpseEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3((desired_player.getX()), (desired_player.getY()), (desired_player.getZ()))).inflate((DoubleArgumentType.getDouble(arguments, "cube")) / 2d),
				e -> true).isEmpty()) {
			corpse_distance = ((findEntityInWorldRange(world, CorpseEntity.class, (desired_player.getX()), (desired_player.getY()), (desired_player.getZ()), (DoubleArgumentType.getDouble(arguments, "cube")))).position())
					.distanceTo((desired_player.position()));
			if (desired_player instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal(("Nearest corpse is " + corpse_distance + " blocks away from " + desired_player.getDisplayName().getString())), false);
		} else {
			if (desired_player instanceof ServerPlayer _player)
				_player.sendSystemMessage(Component.literal("No corpse found nearby."), false);
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}