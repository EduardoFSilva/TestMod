package com.github.eduadofsilva.eduardu44testmod.world.gen;

import java.util.ArrayList;

import com.github.eduadofsilva.eduardu44testmod.registers.BlockRegistryHandler;
import com.github.eduadofsilva.eduardu44testmod.utils.Constantes;
import com.github.eduadofsilva.eduardu44testmod.utils.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGeneration {

	private static  ArrayList<ConfiguredFeature<?, ?>> overworldOres, netherOres, endOres;


	public static void registerOres() {
		if(overworldOres == null) {
			overworldOres = new ArrayList<ConfiguredFeature<?,?>>();
			//name, vein, range, frequency
			overworldOres.add(createOverworldStoneOre("copper_ore", 8, 128, 80));
		}
		if(netherOres == null) {
			netherOres = new ArrayList<ConfiguredFeature<?,?>>();
		}
		if(endOres == null) {
			endOres = new ArrayList<ConfiguredFeature<?,?>>();
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void gen(BiomeLoadingEvent evt) {
		registerOres();
		BiomeGenerationSettingsBuilder generation = evt.getGeneration();
		switch (evt.getCategory()) {
		case NETHER:
			generateOres(netherOres, generation);
			break;
		case THEEND:
			generateOres(endOres, generation);
			break;
		default:
			generateOres(overworldOres, generation);
			break;
		}
	}

	private static void generateOres(ArrayList<ConfiguredFeature<?, ?>> oreList,BiomeGenerationSettingsBuilder gen){ 
		if(!oreList.isEmpty()) {
		for(ConfiguredFeature<?, ?> ore : oreList) {
			if(ore != null) {
				gen.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
	}
	}
	
	

	/**
	 * 
	 * @param name      The string id of the block
	 * @param modid     the modid of the block
	 * @param veinSize  the vein size of the generation
	 * @param range     the range of the generation
	 * @param frequency the generation frequency
	 * @return
	 */
	private static ConfiguredFeature<?, ?> createOverworldStoneOre(String name, int veinSize, int range,
			int frequency) {
		return createGenericOre(name, veinSize, range, frequency, FillerBlockType.BASE_STONE_OVERWORLD);
	}
	/*
	 * private static ConfiguredFeature<?, ?> createOverworldStoneOre(String name,
	 * String modid, int veinSize, int range, int frequency){ Block block =
	 * BlockRegistryHandler.getBlockById(Utils.getNamespacedId(modid, name));
	 * RuleTest ruleTest = FillerBlockType.BASE_STONE_OVERWORLD; OreFeatureConfig
	 * ofc = new OreFeatureConfig(ruleTest,block.getDefaultState(),veinSize);
	 * ConfiguredFeature<?, ?> conf = Feature.ORE.withConfiguration(ofc);
	 * conf.range(range); conf.square(); conf.func_242731_b(frequency); return
	 * register(name, conf);
	 * 
	 * }
	 */

	private static ConfiguredFeature<?, ?> createOverworldDirtOre(String name, int veinSize, int range, int frequency) {
		return createGenericOre(name, veinSize, range, frequency, getRuleTestForVanillaBlock(Blocks.DIRT));
	}

	private static ConfiguredFeature<?, ?> createNetherRackOre(String name, int veinSize, int range, int frequency) {
		return createGenericOre(name, veinSize, range, frequency, FillerBlockType.NETHERRACK);
	}

	private static ConfiguredFeature<?, ?> createEndStoneOre(String name, int veinSize, int range, int frequency) {
		return createGenericOre(name, veinSize, range, frequency, getRuleTestForVanillaBlock(Blocks.END_STONE));
	}

	/**
	 * 
	 * @param name      The string id of the block
	 * @param modid     the modid of the block
	 * @param veinSize  the vein size of the generation
	 * @param range     the range of the generation
	 * @param frequency the generation frequency
	 * @param ruleTest  the rule test block
	 * @return
	 */
	private static ConfiguredFeature<?, ?> createGenericOre(String name, int veinSize, int range, int frequency,
			RuleTest ruleTest) {
		Block block = BlockRegistryHandler.getBlockById(Utils.getModNamespacedId(name));
		OreFeatureConfig ofc = new OreFeatureConfig(ruleTest, block.getDefaultState(), veinSize);
		ConfiguredFeature<?, ?> conf = Feature.ORE.withConfiguration(ofc);
		conf = conf.range(range);
		conf = conf.square();
		conf = conf.func_242731_b(frequency);
		return register(name, conf);

	}

	/**
	 * 
	 * @param <FC>
	 * @param name
	 * @param feature
	 * @return
	 */
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name,
			ConfiguredFeature<FC, ?> feature) {

		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Utils.getModNamespacedId(name), feature);
	}

	private static RuleTest getRuleTestForModBlock(String id) {
		RuleTest rt = new BlockMatchRuleTest(BlockRegistryHandler.getBlockById(Utils.getModNamespacedId(id)));
		return rt;
	}

	private static RuleTest getRuleTestForVanillaBlock(Block block) {
		RuleTest rt = new BlockMatchRuleTest(block);
		return rt;
	}

}
