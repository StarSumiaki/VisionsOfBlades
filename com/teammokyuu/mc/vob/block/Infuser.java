package com.teammokyuu.mc.vob.block;

import java.util.Random;

import com.teammokyuu.mc.vob.client.GuiInfuser;
import com.teammokyuu.mc.vob.container.ContainerDummy;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class Infuser extends BlockWithContainer {

	public Infuser( ) {
		super( Material.rock );
		super.setHardness( 2.5F );
		super.setStepSound( soundTypeStone );
		super.setBlockBounds( 0F, 0F, 0F, 1F, 0.75F, 1F );
	}
	
	private double getOffsetMultiplier( Random rand ) {
		return rand.nextInt( 101 ) < 50 ? -1D : 1D;
	}
	
	/* ----- BEGIN BlockSelfLiaison ----- */

	@Override
	public String getRawName() {
		return "Infuser";
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
		return new ContainerDummy( );
	}

	@Override
	public Object getClientGui( int interactID, EntityPlayer player, World world, int x, int y, int z ) {
		return new GuiInfuser( player.inventory, world, new BlockPos( x, y, z ) );
	}
	
	/* ----- BEGIN Block ----- */
	
	@Override
    public void randomDisplayTick( World world, BlockPos pos, IBlockState state, Random rand ) {
		Random random = world.rand;
		
		for( int i = 0; i < 3; ++i ){
			double d1 = this.getOffsetMultiplier( rand ) * (double)((float)pos.getX() + 0.5F + (random.nextFloat( ) % 0.5F));
			double d2 = (double)((float)pos.getY() + 0.5F + (0.2F * random.nextFloat( )));
			double d3 = this.getOffsetMultiplier( rand ) * (double)((float)pos.getZ() + 0.5F + (random.nextFloat( ) % 0.5F ));

			world.spawnParticle( EnumParticleTypes.CRIT, d1, d2, d3, 0.0D, 0.5D, 0.0D, new int[0] );
		}
    }

}
