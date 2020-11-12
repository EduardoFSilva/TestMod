package com.github.eduadofsilva.eduardu44testmod.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class BlockCopperOre extends OreBlock{

	public BlockCopperOre() {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f,3.0f)
				.sound(SoundType.STONE).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool());
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {

		return 0;
	}
	

}
