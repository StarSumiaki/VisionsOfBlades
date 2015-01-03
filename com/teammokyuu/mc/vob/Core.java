package com.teammokyuu.mc.vob;

import com.teammokyuu.mc.vob.block.Blocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Core.MODID, version = Core.VERSION)
public class Core {

    public static final String MODID = "teammokyuu_vob";
    public static final String VERSION = "1.0.0a";
 
    @EventHandler
    public void preInit( FMLPreInitializationEvent event ) { }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Blocks.setup( event.getSide( ) );
    }
}
