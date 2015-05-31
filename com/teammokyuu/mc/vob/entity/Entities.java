package com.teammokyuu.mc.vob.entity;

import com.teammokyuu.mc.vob.Core;
import com.teammokyuu.mc.vob.entity.monster.InfantCreeper;
import com.teammokyuu.mc.vob.entity.render.InfantCreeperRenderer;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Entities {

	public static void setup( Side side ) {
		
		if( side == Side.CLIENT ) {
    		RenderingRegistry.registerEntityRenderingHandler( InfantCreeper.class, new InfantCreeperRenderer( Minecraft.getMinecraft( ).getRenderManager( ) ) );
    	}
		EntityRegistry.registerModEntity( InfantCreeper.class, "infant_creeper", 2, Core.instance, 64, 1, true );
	}
	
}
