package com.teammokyuu.mc.vob.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

public class ExpandedShapedRecipe extends ShapedRecipes {

	private int gridWidth;
	private int gridHeight;
	
	public ExpandedShapedRecipe( int gridWidth, int gridHeight, int recipeWidth, int recipeHeight, ItemStack[] components, ItemStack result ) {
		super( recipeWidth, recipeHeight, components, result );
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
	}
	
	public static ExpandedShapedRecipe from( int gridWidth, int gridHeight, ShapedRecipes recipe ) {
		return new ExpandedShapedRecipe( gridWidth, gridHeight, recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput( ) );
	}
	
	/* ----- BEGIN ShapedRecipes ----- */

	public boolean matches( InventoryCrafting craftMatrix, World world ) {
		for( int i = 0; i <= this.gridWidth - this.recipeWidth; ++i ) {
			for( int j = 0; j <= this.gridWidth - this.recipeHeight; ++j ) {
				if( this.checkMatch( craftMatrix, i, j, true ) || this.checkMatch( craftMatrix, i, j, false ) )
					return true;
			}
		}
		return false;
	}

	private boolean checkMatch( InventoryCrafting craftMatrix, int slotX, int slotY, boolean flag ) {
		for( int k = 0; k < this.gridWidth; ++k ) {
			for( int l = 0; l < this.gridHeight; ++l ) {
				int i1 = k - slotX;
				int j1 = l - slotY;
				
				ItemStack itemstack = null;

				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (flag)
						itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					else
						itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
				}

				ItemStack itemstack1 = craftMatrix.getStackInRowAndColumn(k, l);

				if (itemstack1 != null || itemstack != null)
				{
					if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
					{
						return false;
					}

					if (itemstack.getItem() != itemstack1.getItem())
					{
						return false;
					}

					if (itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemstack1.getMetadata())
					{
						return false;
					}
				}
			}
		}

		return true;
	}
}
