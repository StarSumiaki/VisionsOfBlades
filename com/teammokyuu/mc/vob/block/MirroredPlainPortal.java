package com.teammokyuu.mc.vob.block;

import java.util.Random;

import com.teammokyuu.mc.vob.Core;
import com.teammokyuu.mc.vob.world.TeleporterMirroredPlain;

import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class MirroredPlainPortal extends BlockPortal {

	public MirroredPlainPortal() {
		// TODO Auto-generated constructor stub
	}

	public void updateTick( World world, BlockPos pos, IBlockState state, Random rand ) { }
	
	@Override
	public void onEntityCollidedWithBlock( World world, BlockPos pos, IBlockState state, Entity entity ) {
		
		if( (entity.ridingEntity == null) && (entity.riddenByEntity == null) && (entity instanceof EntityPlayerMP) ) {
			EntityPlayerMP player = (EntityPlayerMP)entity;
			MinecraftServer mServer = MinecraftServer.getServer();
			
			if( player.dimension != Core.mirroredPlainDimID )
				player.mcServer.getConfigurationManager( ).transferPlayerToDimension(
						player, Core.mirroredPlainDimID, new TeleporterMirroredPlain( mServer.worldServerForDimension( Core.mirroredPlainDimID ) )
				);
		}
	}
}
