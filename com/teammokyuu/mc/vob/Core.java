package com.teammokyuu.mc.vob;

import com.teammokyuu.mc.vob.block.Blocks;
import com.teammokyuu.mc.vob.crafting.Recipes;
import com.teammokyuu.mc.vob.item.Items;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
@Mod(name = "True SwordsPlus: Visions of Blades", modid = Core.MODID, version = Core.VERSION)
public class Core {

    public static final String MODID = "teammokyuu_vob";
    public static final String VERSION = "1.0.0a";
    
	@SidedProxy(clientSide = "com.teammokyuu.mc.vob.client.ClientProxy", serverSide = "com.teammokyuu.mc.vob.CommonProxy")
	public static CommonProxy proxy;
    
	@Instance(MODID)
	public static Core instance;
 
    @EventHandler
    public void preInit( FMLPreInitializationEvent event ) { }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Blocks.setup( event.getSide( ) );
    	Items.setup( event.getSide( ) );
    	Recipes.setup( );
    	NetworkRegistry.INSTANCE.registerGuiHandler( instance, proxy );
    }
}
