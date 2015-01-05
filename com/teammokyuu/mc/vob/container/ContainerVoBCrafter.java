package com.teammokyuu.mc.vob.container;

import com.teammokyuu.mc.vob.block.Blocks;
import com.teammokyuu.mc.vob.crafting.ExpandedShapedRecipe;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerVoBCrafter extends Container {

	private World world;
	private BlockPos location;
	
	public InventoryCrafting craftMatrix = new InventoryCrafting( this, 5, 5 );
	public IInventory craftResult = new InventoryCraftResult( );
	
	public ContainerVoBCrafter( InventoryPlayer inventory, World world, BlockPos location ) {
		this.world = world;
		this.location = location;
		
		this.addSlotToContainer( new SlotCrafting( inventory.player, this.craftMatrix, this.craftResult, 0, 158, 80 ) );
		
		int i;
		int j;

		for (i = 0; i < 5; ++i)
		{
			for (j = 0; j < 5; ++j)
			{
				this.addSlotToContainer( new Slot( this.craftMatrix, j + i * 5, 24 + j * 18, 12 + i * 18 ) );
			}
		}

		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				this.addSlotToContainer( new Slot( inventory, j + i * 9 + 9, 21 + j * 18, 119 + i * 18 ) );
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer( new Slot( inventory, i, 21 + i * 18, 177 ) );
		}

		this.onCraftMatrixChanged( this.craftMatrix );
	}

	/* ----- BEGIN Container ----- */
	
	@Override
	public boolean canInteractWith( EntityPlayer player ) {
		return this.world.getBlockState( this.location ).getBlock() != Blocks.vob_crafter ?
				false :
				player.getDistanceSq((double)this.location.getX( ) + 0.5D, (double)this.location.getY( ) + 0.5D, (double)this.location.getZ( ) + 0.5D) <= 64.0D;
	}
	
	@Override
	public void onCraftMatrixChanged( IInventory craftMatrix ) {
		for( Object o : CraftingManager.getInstance( ).getRecipeList( ) ) {
			
			if( !(o instanceof ExpandedShapedRecipe) )
				continue;
			else {
				ExpandedShapedRecipe r = (ExpandedShapedRecipe)o;
				if( r.matches( this.craftMatrix, this.world ) ) {
					this.craftResult.setInventorySlotContents( 0, r.getCraftingResult( this.craftMatrix ) );
					break;
				}
			}
			
		}
	}
	
	@Override
	public void onContainerClosed( EntityPlayer player ) {
		super.onContainerClosed( player );

		if( !this.world.isRemote ) {
			for( int i = 0; i < 25; ++i ) {
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing( i );
				if( itemstack != null )
					player.dropPlayerItemWithRandomChoice( itemstack, false );
			}
		}
	}

}
