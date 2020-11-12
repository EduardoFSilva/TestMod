package com.github.eduadofsilva.eduardu44testmod.registers;

import com.github.eduadofsilva.eduardu44testmod.blockitem.*;
import com.github.eduadofsilva.eduardu44testmod.utils.Constantes;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemRegistryHandler{

	private static DeferredRegister<Item> blockItemRegistries;

	public static void init() {
		blockItemRegistries = DeferredRegister.create(ForgeRegistries.ITEMS, Constantes.MOD_ID);
		registrarItemDeBlocos();
		blockItemRegistries.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private static void registrarItemDeBlocos() {
		blockItemRegistries.register("test_block", BlockItemTest::new);
		blockItemRegistries.register("copper_block", BlockItemCopper::new);
		blockItemRegistries.register("copper_ore", BlockItemCopperOre::new);

	}
	
	public static Item getBlockItemById(String id) {
		Item item = null;
		ResourceLocation location;
		String name = "";
		for(RegistryObject<Item> itemRo : blockItemRegistries.getEntries()) {
			item = itemRo.get();
			location = item.getRegistryName();
			name = String.format("%s:%s", location.getNamespace(),location.getPath());
			if(name.equals(id)) {
				return item;
			}
			
		}
		return null;
	}
}
