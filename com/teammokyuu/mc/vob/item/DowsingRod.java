package com.teammokyuu.mc.vob.item;

import java.util.List;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class DowsingRod extends ItemSelfLiaison {

	public DowsingRod() {
		super.maxStackSize = 1;
		this.setCreativeTab( CreativeTabs.tabTools );
		super.setUnlocalizedName( this.getRawName( ) );
	}

	/* ---- BEGIN ItemSelfLiaison ----- */
	
	@Override
	public ItemSelfLiaison registerModel( Side side ) {
		super.registerModel( side );
		if( side == Side.CLIENT ) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
					this,
					1,
					new ModelResourceLocation( Core.MODID + ":" + this.getBlockModelResourceName( ) + "_Ping", "inventory" )
			);
			ModelBakery.addVariantName( this, new String[ ]{ Core.MODID + ":DowsingRod", Core.MODID + ":DowsingRod_Ping" } );
		}
		return this;
	}
	
	
	@Override
	public String getRawName( ) {
		return "DowsingRod";
	}
	
	/* ---- BEGIN Item ----- */
	
	@Override
	public void getSubItems( Item item, CreativeTabs tab, List subItems ) {
		subItems.add( new ItemStack( this, 1 ) );
		subItems.add( new ItemStack( this, 1, 1 ) );
	}
	
	/*
	@Override
	public void onUpdate( ItemStack stack, World world, Entity holder, int slot, boolean held ) {
		if( world.isRemote && holder.dimension == Core.mirroredPlainDimID && (holder instanceof EntityPlayer) ) {
			EntityPlayer player = (EntityPlayer)holder;
			
			if( player.isUsingItem( ) && stack.getItemDamage( ) != 1 )
				stack.setItemDamage( 1 );
			else {
				if( stack.getItemDamage( ) != 0 )
					stack.setItemDamage( 0 );
			}
				
		}
	}
	 */
	
	@Override
	public ItemStack onItemRightClick( ItemStack stack, World world, EntityPlayer player ) {
		
		int damage = stack.getItemDamage( );
		stack.setItemDamage( damage == 0 ? 1 : 0 );
		
		return stack;
	}
}
