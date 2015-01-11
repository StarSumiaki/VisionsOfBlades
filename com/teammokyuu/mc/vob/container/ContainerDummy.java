package com.teammokyuu.mc.vob.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Dummy container for placeholder purposes.
 * Originally conceived for a really hackish idea to get 3x3 crafting table recipes working in the VoBCrafter
 * (Could probably be deprecated and removed but meh?)
 *
 */
public class ContainerDummy extends Container {

	public ContainerDummy( ) { }

	/* ----- BEGIN Container ----- */
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
