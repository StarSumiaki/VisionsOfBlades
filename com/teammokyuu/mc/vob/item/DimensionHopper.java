package com.teammokyuu.mc.vob.item;

import com.teammokyuu.mc.vob.Core;
import com.teammokyuu.mc.vob.world.TeleporterMirroredPlain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class DimensionHopper extends ItemSelfLiaison {

	public DimensionHopper( ) {
		super.setUnlocalizedName( this.getRawName( ) );
	}

	/* ---- BEGIN ItemSelfLiaison ----- */
	
	@Override
	public String getRawName( ) {
		return "DimensionHopper";
	}
	
	/* ---- BEGIN Item ----- */
	
	@Override
	public ItemStack onItemRightClick( ItemStack stack, World world, EntityPlayer player ) {
		if( (player.ridingEntity == null) && (player.riddenByEntity == null) && (player instanceof EntityPlayerMP) ) {
			EntityPlayerMP playerMP = (EntityPlayerMP)player;
			MinecraftServer mServer = MinecraftServer.getServer();
			
			int dim = playerMP.dimension == 0 ? Core.mirroredPlainDimID : 0;
			
			playerMP.mcServer.getConfigurationManager( ).transferPlayerToDimension(
					playerMP, dim, new TeleporterMirroredPlain( mServer.worldServerForDimension( dim ) )
			);
		}
		return stack;
	}
}
