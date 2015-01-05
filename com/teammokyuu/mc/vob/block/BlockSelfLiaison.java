package com.teammokyuu.mc.vob.block;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public abstract class BlockSelfLiaison extends Block {
	
	protected BlockSelfLiaison( Material material ) {
		super( material );
		super.setUnlocalizedName( this.getRawName( ) );
	}
	
	/**
	 * Call to register itself.
	 */
	final public BlockSelfLiaison registerSelf( ) {
		GameRegistry.registerBlock( this, this.getItemBlockClass( ), this.getRawName( ), this.getItemBlockClassConstructorArgs( ) );
		return this;
	}
	
	/**
	 * Call to register model JSON stuffs.
	 * 
	 * @param side	The effective side. For purpose of stupid chaining while maintaining proper siding.
	 */
	public BlockSelfLiaison registerModel( Side side ) {
		if( side == Side.CLIENT ) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
					Item.getItemFromBlock( this ),
					0,
					new ModelResourceLocation( Core.MODID + ":" + this.getBlockModelResourceName( ), "inventory" )
			);
		}
		return this;
	}
	
	/**
	 * Returns the raw (unlocalized) name.
	 * <p>
	 * Mostly used for JSON reasons but kept separate anyway.
	 */
	abstract public String getRawName( );
	
	/**
	 * Returns the ItemBlock (sub-)class to use.
	 */
	public Class<? extends ItemBlock> getItemBlockClass( ) {
		return ItemBlock.class;
	}
	
	/**
	 * Returns the constructor args to pass into the ItemBlock class, if any.
	 */
	public Object[] getItemBlockClassConstructorArgs( ) {
		return new Object[]{};
	}
	
	/**
	 * Returns the name used for the JSON files for models/states
	 */
	public String getBlockModelResourceName( ) {
		return this.getRawName( );
	}
	
	/**
	 * Returns whether or not this is a standard cube (full and opaque)
	 */
	public boolean isStandardCube( ) {
		return false;
	}
	
	/* ----- BEGIN Block ----- */
	
	@Override
	public final boolean isFullCube( ) {
		return this.isStandardCube( );
	}

	@Override
	public final boolean isOpaqueCube( ) {
		return this.isStandardCube( );
	}
}
