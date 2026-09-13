package net.mcreator.worldstudiosworld.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class NeziumIngotItem extends Item {
	public NeziumIngotItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}
}