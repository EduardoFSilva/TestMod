package com.github.eduadofsilva.eduardu44testmod.block;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockTest extends Block{

	public BlockTest() {
		super(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f,6.0f)
				.sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE));
		// TODO Auto-generated constructor stub
	}

}
