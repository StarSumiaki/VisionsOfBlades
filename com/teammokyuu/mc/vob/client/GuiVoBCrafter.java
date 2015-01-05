package com.teammokyuu.mc.vob.client;

import com.teammokyuu.mc.vob.Core;
import com.teammokyuu.mc.vob.container.ContainerVoBCrafter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiVoBCrafter extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation( Core.MODID + ":textures/gui/VoBCrafterGui.png" );

    public GuiVoBCrafter( InventoryPlayer inventory, World world ) {
        this( inventory, world, BlockPos.ORIGIN );
    }

    public GuiVoBCrafter( InventoryPlayer inventory, World world, BlockPos location ) {
        super( new ContainerVoBCrafter( inventory, world, location ) );
        this.xSize = 202;
        this.ySize = 201;
    }

    /* ----- BEGIN GuiContainer ----- */
    
    @Override
    protected void drawGuiContainerForegroundLayer( int mouseX, int mouseY ) {
        //this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer( float partialTicks, int mouseX, int mouseY ) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
    
}
