package com.teammokyuu.mc.vob.block;

import net.minecraftforge.fml.relauncher.Side;

public class Blocks {
	
	public static void setup( Side side ) {
		(new VoBCrafter( )).registerSelf( ).registerModel( side );
	}

}
