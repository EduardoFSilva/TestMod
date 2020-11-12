package com.github.eduadofsilva.eduardu44testmod.utils;

import com.github.eduadofsilva.eduardu44testmod.registers.ItemRegistryHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Constantes {

	public static final String MOD_ID = "eduardu44testmod";
	public static final ItemGroup CUSTOM_ITEM_GROUP = new ItemGroup("testmod_tab") {
		
		@Override
		public ItemStack createIcon() {
			Item item = ItemRegistryHandler.getItemById(Utils.getModNamespacedId("test_item"));
			return new ItemStack(item);
		}
	};
}
