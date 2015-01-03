package com.teammokyuu.mc.vob.block;

import net.minecraft.block.material.Material;

public class VoBCrafter extends BlockSelfLiaison {

	public VoBCrafter( ) {
		super( Material.rock );
		super.setHardness( 2.5F );
		super.setStepSound( soundTypeStone );
	}

	/* ----- BEGIN IBlockSelfLiaison ----- */
	
	@Override
	public String getRawName( ) {
		return "VoBCrafter";
	}

}
