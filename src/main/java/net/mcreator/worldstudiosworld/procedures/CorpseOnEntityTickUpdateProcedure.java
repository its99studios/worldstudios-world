package net.mcreator.worldstudiosworld.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;

public class CorpseOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity Owner = null;
		if (entity.getPersistentData().getStringOr("OwnerUUID", "") != null) {
			Owner = world instanceof ServerLevel _level2 ? getEntityFromUUID(_level2, (entity.getPersistentData().getStringOr("OwnerUUID", ""))) : null;
			if ((entity.position()).distanceTo((Owner.position())) > 96) {
				{
					Entity _ent = entity;
					double _tx = (Owner.getX() + Mth.nextInt(RandomSource.create(), 33, 66));
					double _ty = (Owner.getY() + Mth.nextInt(RandomSource.create(), 33, 66));
					double _tz = (Owner.getZ() + Mth.nextInt(RandomSource.create(), 33, 66));
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}

	private static Entity getEntityFromUUID(ServerLevel level, String uuid) {
		try {
			return level.getEntity(UUID.fromString(uuid));
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}