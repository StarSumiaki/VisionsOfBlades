package com.teammokyuu.mc.vob.item;

import net.minecraftforge.fml.relauncher.Side;

public class Items {

	public static SwordBase iron_blade;
	
	public static void setup( Side side ) {
		iron_blade = (SwordBase)(new SwordBase( SwordType.IRON_BLADE )).registerSelf( ).registerModel( side );
	}

}
