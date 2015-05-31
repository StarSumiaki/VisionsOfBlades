package com.teammokyuu.mc.vob.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

	public static void setup( ) {
		
		GameRegistry.addShapedRecipe( new ItemStack( com.teammokyuu.mc.vob.block.Blocks.vob_crafter ), new Object[] {
    		"wCw",
    		"sOs",
    		"sss",
    		'w', Blocks.wooden_slab,
    		'C', Blocks.crafting_table,
    		'O', Blocks.obsidian,
    		's', Blocks.stone_slab
    	});
		
    	GameRegistry.addRecipe( new ExpandedShapedRecipe(
    			5, 5, 5, 5,
    			new ItemStack[] {
    					null, null, null, null, new ItemStack( Items.iron_ingot ),
    					null, null, null, new ItemStack( Items.iron_ingot ), null,
    					null, new ItemStack( Items.iron_ingot ), new ItemStack( Items.iron_ingot ), null, null,
    					null, new ItemStack( Items.stick ), new ItemStack( Items.iron_ingot ), null, null,
    					new ItemStack( Items.stick ), null, null, null, null
    			},
    			new ItemStack( com.teammokyuu.mc.vob.item.Items.iron_blade )
    	) );
    	
    	GameRegistry.addRecipe( new ExpandedShapedRecipe(
    			5, 5, 5, 5,
    			new ItemStack[] {
    					null, null, new ItemStack( Items.stick ), null, null,
    					null, null, new ItemStack( Items.stick ), null, null,
    					null, null, new ItemStack( Items.stick ), new ItemStack( Items.stick ), new ItemStack( Items.stick ),
    					null, new ItemStack( Items.stick ), null, null, null,
    					new ItemStack( Items.stick ), null, null, null, null
    			},
    			new ItemStack( com.teammokyuu.mc.vob.item.Items.dowsing_rod )
    	) );
	}

}
