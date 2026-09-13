/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.worldstudiosworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.worldstudiosworld.WorldstudiosWorldMod;

public class WorldstudiosWorldModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, WorldstudiosWorldMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> FAIRY_AMBIENT = REGISTRY.register("fairy.ambient", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("worldstudios_world", "fairy.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOID_BLOCK_IDLE = REGISTRY.register("void_block.idle", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("worldstudios_world", "void_block.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VOID_BLOCK_SHORT = REGISTRY.register("void_block.short", () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath("worldstudios_world", "void_block.short")));
}