package com.github.eduadofsilva.eduardu44testmod.registers;


import com.github.eduadofsilva.eduardu44testmod.item.*;
import com.github.eduadofsilva.eduardu44testmod.utils.Constantes;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistryHandler {
	
	//Declaração De Instancia
	//DeferredRegister: Usado Para Armazenar Dados, funciona tipo ArrayList
	private static DeferredRegister<Item> itemRegistries;
	
	//Constantes De Itens
	
	public static void init() {
		itemRegistries = DeferredRegister.create(ForgeRegistries.ITEMS,Constantes.MOD_ID);
		registrarItens();
		itemRegistries.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	private static void registrarItens() {
		itemRegistries.register("test_item", ItemTest::new); //Test Item
		itemRegistries.register("copper_ingot", ItemCopperIngot::new);	
	}
	
	public static Item getItemById(String id) {
		Item item = null;
		ResourceLocation location;
		String name = "";
		for(RegistryObject<Item> itemRo : itemRegistries.getEntries()) {
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
