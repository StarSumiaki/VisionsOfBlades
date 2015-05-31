package com.teammokyuu.mc.vob.world;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMirroredPlain extends WorldProvider {

	private static final Vec3 SKY_COLOR = new Vec3( 21D/255D, 74D/255D, 145D/255D );
	
	public WorldProviderMirroredPlain( ) {
		// TODO Auto-generated constructor stub
	}
	
	/* ----- BEGIN WorldProvider ----- */

	@Override
	public String getDimensionName( ) {
		return "Mirrored Plain";
	}

	@Override
	public String getInternalNameSuffix( ) {
		return "";
	}
	
	@Override
	public void registerWorldChunkManager( ) {
		super.worldChunkMgr = new WorldChunkManagerMirroredPlain( super.worldObj );
		this.dimensionId = Core.mirroredPlainDimID;
		
	}
	
	@Override
	public IChunkProvider createChunkGenerator( ) {
		return new ChunkProviderMirroredPlain( worldObj );
	}
	
	@Override
	public boolean isSurfaceWorld( ) {
		return false;
	}
	
	@Override
	public boolean canRespawnHere( ) {
		return false;
	}
	
	@Override
	public String getWelcomeMessage( ) {
		return "Entering the Mirrored Plain";
	}
	
	@Override
	public String getDepartMessage( ) {
		return "Leaving the Mirrored Plain";
    }
	
	// This is probably NOT how you create a temporally frozen dimension like Twilight Forest but ¯\_(`・ω・´)_/¯
	@Override
	public long getWorldTime( ) {
		return 15000L;
	}
	
	@Override
	public Vec3 getSkyColor( Entity cameraEntity, float partialTicks ) {
		return SKY_COLOR;
    }
	
	@Override
	public boolean canMineBlock( EntityPlayer player, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean canDoLightning( Chunk chunk ) {
		return false;
	}

	@Override
	public boolean canDoRainSnowIce( Chunk chunk ) {
		return false;
	}
}
