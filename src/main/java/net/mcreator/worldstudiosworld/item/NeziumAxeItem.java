package net.mcreator.worldstudiosworld.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class NeziumAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1741, 14f, 0, 56, TagKey.create(Registries.ITEM, Identifier.parse("worldstudios_world:nezium_axe_repair_items")));

	public NeziumAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 15f, 8f, properties);
	}
}