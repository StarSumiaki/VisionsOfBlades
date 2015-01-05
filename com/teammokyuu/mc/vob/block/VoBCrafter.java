package com.teammokyuu.mc.vob.block;

import com.teammokyuu.mc.vob.client.GuiVoBCrafter;
import com.teammokyuu.mc.vob.container.ContainerVoBCrafter;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class VoBCrafter extends BlockWithContainer {

	public VoBCrafter( ) {
		super( Material.rock );
		super.setHardness( 2.5F );
		super.setStepSound( soundTypeStone );
	}

	/* ----- BEGIN BlockSelfLiaison ----- */
	
	@Override
	public String getRawName( ) {
		return "VoBCrafter";
	}
	
	/* ----- BEGIN BlockWithContainer ----- */

	@Override
	public int getInteractID(
			World world,
			BlockPos pos,
			IBlockState blockState,
			EntityPlayer player,
			EnumFacing direction,
			float hitX,
			float hitY,
			float hitZ
	) {
		return 1;
	}

	@Override
	public Object getServerContainer( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		return new ContainerVoBCrafter( player.inventory, world, new BlockPos( x, y, z ) );
	}

	@Override
	public Object getClientGui( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		return new GuiVoBCrafter( player.inventory, world, new BlockPos( x, y, z ) );
	}

}
