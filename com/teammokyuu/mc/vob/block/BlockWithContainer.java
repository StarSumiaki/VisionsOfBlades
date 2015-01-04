package com.teammokyuu.mc.vob.block;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BlockWithContainer extends BlockSelfLiaison {

	protected BlockWithContainer( Material material ) {
		super(material);
	}
	
	/**
	 * Returns an integer ID representing the type of interaction that occurred or 0 if nothing.
	 */
	abstract public int getInteractID( 
			World world,
    		BlockPos pos,
    		IBlockState blockState,
    		EntityPlayer player,
    		EnumFacing direction,
    		float hitX,
    		float hitY,
    		float hitZ
    );
	
	/**
	 * Returns the Container object needed by the Server for the given interaction.
	 * @param interactID	An ID to determine the Container needed (for if one block has fancy interaction)
	 */
	abstract public Object getServerContainer( int interactID, EntityPlayer player, World world, int x, int y, int z );
	
	/**
	 * Returns the Gui object needed by the Client for the given interaction.
	 * @param interactID	An ID to determine the Gui needed (for if one block has fancy interaction)
	 */
	abstract public Object getClientGui( int interactID, EntityPlayer player, World world, int x, int y, int z  );

	/* ----- BEGIN Block ----- */
	
	@Override
    public final boolean onBlockActivated(
    		World world,
    		BlockPos pos,
    		IBlockState blockState,
    		EntityPlayer player,
    		EnumFacing direction,
    		float hitX,
    		float hitY,
    		float hitZ
    ){
		int interactID = this.getInteractID( world, pos, blockState, player, direction, hitX, hitY, hitZ );
		if( interactID != 0 )
			player.openGui( Core.instance, interactID, world, pos.getX( ), pos.getY( ), pos.getZ( ) );
		return true;
	}

}
