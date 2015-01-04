package com.teammokyuu.mc.vob.client;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.teammokyuu.mc.vob.CommonProxy;
import com.teammokyuu.mc.vob.block.BlockWithContainer;

public class ClientProxy extends CommonProxy {

	/* ----- BEGIN CommonProxy / IGuiHandler ----- */
	
	@Override
	public Object getClientGuiElement( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		Block block = world.getBlockState( new BlockPos( x, y, z ) ).getBlock( );
		return block instanceof BlockWithContainer ? ((BlockWithContainer)block).getClientGui( interactID, player, world, x, y, z ) : null;
	}

}
