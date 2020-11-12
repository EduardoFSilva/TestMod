package com.github.eduadofsilva.eduardu44testmod.blockitem;

import com.github.eduadofsilva.eduardu44testmod.registers.BlockRegistryHandler;
import com.github.eduadofsilva.eduardu44testmod.utils.Constantes;
import com.github.eduadofsilva.eduardu44testmod.utils.Utils;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemCopperOre extends BlockItem{

	public BlockItemCopperOre() {
		super(BlockRegistryHandler.getBlockById(Utils.getModNamespacedId("copper_ore")),
				new Item.Properties().group(Constantes.CUSTOM_ITEM_GROUP));
		
	}

}
