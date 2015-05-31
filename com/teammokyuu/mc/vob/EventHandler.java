package com.teammokyuu.mc.vob;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.FoodStats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	public static final ResourceLocation HUD_ICONS = new ResourceLocation( Core.MODID + ":textures/gui/hud.png" );
	public static final ResourceLocation TINT = new ResourceLocation( Core.MODID + ":textures/gui/tint.png" );
	private final Minecraft mc = Minecraft.getMinecraft( );
	private Random rand = new Random( );
	private ScaledResolution res = new ScaledResolution( this.mc, this.mc.displayWidth, this.mc.displayHeight );
	private float zLevel = 1F;

	public EventHandler() { }
	
	@SubscribeEvent( priority=EventPriority.HIGHEST, receiveCanceled=false )
	public void handleEvent( BlockEvent.PlaceEvent e ) {
		if( e.player.dimension == Core.mirroredPlainDimID )
			e.setCanceled( true );
	}
	
	@SubscribeEvent( priority=EventPriority.HIGHEST, receiveCanceled=false )
	public void handleEvent( PlayerEvent.BreakSpeed e ) {
		if( e.entityPlayer.dimension == Core.mirroredPlainDimID )
			e.setCanceled( true );
	}

	@SubscribeEvent( priority=EventPriority.HIGHEST, receiveCanceled=true )
	public void handleEvent( RenderGameOverlayEvent.Pre e ) {
		
		EntityPlayer p = Minecraft.getMinecraft( ).thePlayer;
		
		if( p.dimension != Core.mirroredPlainDimID )
			return;
		
		switch( e.type ) {
			case HEALTH:
				this.drawMirroredPlainHUD( p );
				e.setCanceled( true );
				break;
			case FOOD:
			case ARMOR:
			case EXPERIENCE:
				e.setCanceled( true );
			default:
				break;
		}

	}
	
	/*
	private void drawMirroredPlainTint( ) {
		this.mc.getTextureManager( ).bindTexture( TINT );
		GlStateManager.enableBlend( );
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV(0.0D, (double)this.res.getScaledHeight(), -90.0D, 0.0D, 1.0D);
		worldrenderer.addVertexWithUV((double)this.res.getScaledWidth(), (double)this.res.getScaledHeight(), -90.0D, 1.0D, 1.0D);
		worldrenderer.addVertexWithUV((double)this.res.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
		worldrenderer.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
	}
	*/
	
	// Cripes, this is the worst copypasta EVER D:
	private void drawMirroredPlainHUD( EntityPlayer entityplayer ) {
		this.mc.getTextureManager( ).bindTexture( HUD_ICONS );
		GlStateManager.enableBlend( );
		
		int i = MathHelper.ceiling_float_int(entityplayer.getHealth());
		FoodStats foodstats = entityplayer.getFoodStats();
		
		int k = foodstats.getFoodLevel();
		//int l = foodstats.getPrevFoodLevel();
		
		int i1 = this.res.getScaledWidth( ) / 2 - 91;
		int j1 = this.res.getScaledWidth() / 2 + 91;
		int k1 = this.res.getScaledHeight() - 39;
		
		IAttributeInstance iattributeinstance = entityplayer.getEntityAttribute( SharedMonsterAttributes.maxHealth );
		float f = (float)iattributeinstance.getAttributeValue();
		float f1 = entityplayer.getAbsorptionAmount();
		float f2 = f1;
		
		int l1 = MathHelper.ceiling_float_int((f + f1) / 2.0F / 10.0F);
		int i2 = Math.max(10 - (l1 - 2), 3);
		int l2 = -1;
		
		int i3;
		int j3;
		
		int k3;
		int l3;
		int i4;

		for (i3 = MathHelper.ceiling_float_int((f + f1) / 2.0F) - 1; i3 >= 0; --i3)
		{
			j3 = 16;

			byte b0 = 0;

			k3 = MathHelper.ceiling_float_int((float)(i3 + 1) / 10.0F) - 1;
			l3 = i1 + i3 % 10 * 8;
			i4 = k1 - k3 * i2;

			if (i <= 4)
			{
				i4 += this.rand.nextInt(2);
			}

			if (i3 == l2)
			{
				i4 -= 2;
			}

			byte b1 = 0;

			if (entityplayer.worldObj.getWorldInfo().isHardcoreModeEnabled())
			{
				b1 = 5;
			}

			this.drawTexturedModalRect(l3, i4, 16 + b0 * 9, 9 * b1, 9, 9);

			if (f2 > 0.0F)
			{
				if (f2 == f1 && f1 % 2.0F == 1.0F)
				{
					this.drawTexturedModalRect(l3, i4, j3 + 153, 9 * b1, 9, 9);
				}
				else
				{
					this.drawTexturedModalRect(l3, i4, j3 + 144, 9 * b1, 9, 9);
				}

				f2 -= 2.0F;
			}
			else
			{
				if (i3 * 2 + 1 < i)
				{
					this.drawTexturedModalRect(l3, i4, j3 + 36, 9 * b1, 9, 9);
				}

				if (i3 * 2 + 1 == i)
				{
					this.drawTexturedModalRect(l3, i4, j3 + 45, 9 * b1, 9, 9);
				}
			}
		}
		
		int i5;
		
		for (j3 = 0; j3 < 10; ++j3)
		{
			i5 = k1;
			k3 = 16;
			byte b4 = 0;

			if (entityplayer.isPotionActive(Potion.hunger))
			{
				k3 += 36;
				b4 = 13;
			}

			i4 = j1 - j3 * 8 - 9;
			this.drawTexturedModalRect(i4, i5, 16 + b4 * 9, 27, 9, 9);

			if (j3 * 2 + 1 < k)
			{
				this.drawTexturedModalRect(i4, i5, k3 + 36, 27, 9, 9);
			}

			if (j3 * 2 + 1 == k)
			{
				this.drawTexturedModalRect(i4, i5, k3 + 45, 27, 9, 9);
			}
		}
	}
	
	private void drawTexturedModalRect( int x, int y, int textureX, int textureY, int width, int height ) {
		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldrenderer = tessellator.getWorldRenderer();
		worldrenderer.startDrawingQuads();
		worldrenderer.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(textureX + 0) * f), (double)((float)(textureY + height) * f1));
		worldrenderer.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(textureX + width) * f), (double)((float)(textureY + height) * f1));
		worldrenderer.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(textureX + width) * f), (double)((float)(textureY + 0) * f1));
		worldrenderer.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(textureX + 0) * f), (double)((float)(textureY + 0) * f1));
		tessellator.draw();
	}
}
