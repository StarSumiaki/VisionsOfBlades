package com.teammokyuu.mc.vob.item;

import net.minecraft.item.Item;

public enum SwordType {

	IRON_BLADE( "IronBlade", 4F, Item.ToolMaterial.IRON, 500 );
	
	final public String rawName;
	
	final public float baseDamage;
	final public Item.ToolMaterial repairMaterial;
	
	final public int durability;
	
	private SwordType( String rawName, float baseDamage, Item.ToolMaterial repairMaterial, int durability ) {
		this.rawName = rawName;
		this.baseDamage = baseDamage;
		this.repairMaterial = repairMaterial;
		this.durability = durability;
	}

}
