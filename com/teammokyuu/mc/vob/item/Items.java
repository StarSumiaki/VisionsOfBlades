package com.teammokyuu.mc.vob.item;

import net.minecraftforge.fml.relauncher.Side;

public class Items {

	public static SwordBase iron_blade;
	public static DimensionHopper dimension_hopper;
	public static DowsingRod dowsing_rod;
	
	public static void setup( Side side ) {
		iron_blade = (SwordBase)(new SwordBase( SwordType.IRON_BLADE )).registerSelf( ).registerModel( side );
		dimension_hopper = (DimensionHopper)(new DimensionHopper( )).registerSelf( ).registerModel( side );
		dowsing_rod = (DowsingRod)(new DowsingRod( )).registerSelf( ).registerModel( side );
	}

}
