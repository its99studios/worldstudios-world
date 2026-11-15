package net.mcreator.worldstudiosworld.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class CorpseOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity nearest_player = null;
		entity.getPersistentData().putDouble("FollowTimer", (entity.getPersistentData().getDoubleOr("FollowTimer", 0) + 1));
		if (entity.getPersistentData().getDoubleOr("FollowTimer", 0) >= 5) {
			entity.getPersistentData().putDouble("FollowTimer", 0);
			nearest_player = findEntityInWorldRange(world, Player.class, x, y, z, 128);
			if (nearest_player != null) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((nearest_player.getX()), (nearest_player.getY()), (nearest_player.getZ()), 1);
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}