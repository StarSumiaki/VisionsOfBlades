package com.teammokyuu.mc.vob.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterMirroredPlain extends Teleporter {

	private final WorldServer worldServerInstance;
	
	public TeleporterMirroredPlain( WorldServer server ) {
		super( server );
		this.worldServerInstance = server;
	}
	
	@Override
	public void func_180266_a(Entity entity, float p_180266_2_) {
		entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		
		for( int y = (int)entity.posY; y < this.worldServerInstance.getActualHeight( ); ++y ) {
			boolean a1 = this.worldServerInstance.isAirBlock( new BlockPos( entity.posX, (double)y, entity.posZ ) );
			boolean a2 = this.worldServerInstance.isAirBlock( new BlockPos( entity.posX, (double)y + 1D, entity.posZ ) );
			
			if( a1 && a2 ) {
				entity.posY = (double)y;
				break;
			}
		}
	}

}
