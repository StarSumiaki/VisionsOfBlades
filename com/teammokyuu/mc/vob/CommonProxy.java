package com.teammokyuu.mc.vob;

import com.teammokyuu.mc.vob.block.BlockWithContainer;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	
	/* ----- BEGIN IGuiHandler ----- */

	@Override
	public Object getServerGuiElement( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		Block block = world.getBlockState( new BlockPos( x, y, z ) ).getBlock( );
		return block instanceof BlockWithContainer ? ((BlockWithContainer)block).getServerContainer( interactID, player, world, x, y, z ) : null;
	}

	@Override
	public Object getClientGuiElement( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		return null;
	}

}
