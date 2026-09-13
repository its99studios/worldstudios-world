package net.mcreator.worldstudiosworld.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.worldstudiosworld.procedures.VoidStickLivingEntityIsHitWithToolProcedure;
import net.mcreator.worldstudiosworld.init.WorldstudiosWorldModItems;

@EventBusSubscriber
public class VoidStickItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 9f, 0, 2, TagKey.create(Registries.ITEM, Identifier.parse("worldstudios_world:void_stick_repair_items")));

	public VoidStickItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 19f, -2f).rarity(Rarity.RARE).fireResistant());
	}

	@SubscribeEvent
	public static void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
		event.modify(WorldstudiosWorldModItems.VOID_STICK.get(), (builder, _, _) -> builder.set(DataComponents.MAX_DAMAGE, null));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		VoidStickLivingEntityIsHitWithToolProcedure.execute(entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}