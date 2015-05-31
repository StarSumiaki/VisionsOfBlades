package com.teammokyuu.mc.vob.world;

import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class ChunkProviderMirroredPlain extends ChunkProviderGenerate {

	public ChunkProviderMirroredPlain( World world ) {
		super( world, world.getSeed( ), world.getWorldInfo( ).isMapFeaturesEnabled( ), world.getWorldInfo( ).getGeneratorOptions( ) );
	}

}
