package com.teammokyuu.mc.vob.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDummy extends Container {

	public ContainerDummy( ) { }

	/* ----- BEGIN Container ----- */
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return false;
	}

}
