package net.mcreator.worldstudiosworld.entity;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.entity.EntityType;

import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModItems;

public class ChorusChestBoatEntity extends ChestBoat {
	public ChorusChestBoatEntity(EntityType<ChorusChestBoatEntity> type, Level world) {
		super(type, world, WorldstudiosWorldModItems.CHORUS_CHEST_BOAT);
	}
}