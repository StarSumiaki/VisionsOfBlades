package com.teammokyuu.mc.vob.client;

import com.teammokyuu.mc.vob.container.ContainerDummy;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class GuiInfuser extends GuiContainerBase {

    public GuiInfuser( InventoryPlayer inventory, World world ) {
        this( inventory, world, BlockPos.ORIGIN );
    }

    public GuiInfuser( InventoryPlayer inventory, World world, BlockPos location ) {
        super( new ContainerDummy( ) );
        super.withTexture( "InfuserGui" ).ofSize( 202, 201 );
    }
    
}
