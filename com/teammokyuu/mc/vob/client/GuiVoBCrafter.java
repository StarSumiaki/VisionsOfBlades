package com.teammokyuu.mc.vob.client;

import com.teammokyuu.mc.vob.container.ContainerVoBCrafter;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GuiVoBCrafter extends GuiContainerBase {

    public GuiVoBCrafter( InventoryPlayer inventory, World world ) {
        this( inventory, world, BlockPos.ORIGIN );
    }

    public GuiVoBCrafter( InventoryPlayer inventory, World world, BlockPos location ) {
        super( new ContainerVoBCrafter( inventory, world, location ) );
        super.withTexture( "VoBCrafterGui" ).ofSize( 202, 201 );
    }

}
