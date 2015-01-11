package com.teammokyuu.mc.vob.client;

import com.teammokyuu.mc.vob.Core;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiContainerBase extends GuiContainer {

	private ResourceLocation texture;
	
	public GuiContainerBase( Container container ) {
		super( container );
	}
	
	public GuiContainerBase withTexture( String texture ) {
		this.texture = new ResourceLocation( Core.MODID + ":textures/gui/" + texture + ".png" );
		return this;
	}
	
	public GuiContainerBase ofSize( int xSize, int ySize ) {
		this.xSize = xSize;
        this.ySize = ySize;
        return this;
	}

    /* ----- BEGIN GuiContainer ----- */
	
    @Override
    protected void drawGuiContainerBackgroundLayer( float partialTicks, int mouseX, int mouseY ) {
        GlStateManager.color( 1.0F, 1.0F, 1.0F, 1.0F );
        this.mc.getTextureManager().bindTexture( this.texture );
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect( k, l, 0, 0, this.xSize, this.ySize );
    }

}
