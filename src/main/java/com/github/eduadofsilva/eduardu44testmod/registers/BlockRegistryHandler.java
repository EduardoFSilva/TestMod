package com.github.eduadofsilva.eduardu44testmod.registers;

import com.github.eduadofsilva.eduardu44testmod.block.*;
import com.github.eduadofsilva.eduardu44testmod.utils.Constantes;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistryHandler {

	private static DeferredRegister<Block> blockRegistries;
	
	public static void init() {
		blockRegistries = DeferredRegister.create(ForgeRegistries.BLOCKS, Constantes.MOD_ID);
		registrarBlocos();
		blockRegistries.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private static void registrarBlocos() {
		blockRegistries.register("test_block", BlockTest::new);
		blockRegistries.register("copper_block", BlockCopper::new);
		blockRegistries.register("copper_ore", BlockCopperOre::new);
	}
	
	public static Block getBlockById(String id) {
		Block block = null;
		ResourceLocation location;
		String name = "";
		for(RegistryObject<Block> blockRo : blockRegistries.getEntries()) {
			block = blockRo.get();
			location = block.getRegistryName();
			name = String.format("%s:%s", location.getNamespace(),location.getPath());
			if(name.equals(id)) {
				return block;
			}
			
		}
		return null;
	}
}
