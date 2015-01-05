package com.teammokyuu.mc.vob.item;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public abstract class ItemSelfLiaison extends Item {
	
	public final ItemSelfLiaison registerSelf( ) {
		GameRegistry.registerItem( this, this.getRawName( ) );
		return this;
	}
	
	public ItemSelfLiaison registerModel( Side side ) {
		if( side == Side.CLIENT ) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
					this,
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
	 * Returns the name used for the JSON files for models/states
	 */
	public String getBlockModelResourceName( ) {
		return this.getRawName( );
	}
}
