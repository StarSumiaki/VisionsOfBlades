package com.teammokyuu.mc.vob;

import java.io.File;

import org.apache.logging.log4j.Level;

import com.teammokyuu.mc.vob.block.Blocks;
import com.teammokyuu.mc.vob.crafting.Recipes;
import com.teammokyuu.mc.vob.entity.Entities;
import com.teammokyuu.mc.vob.item.Items;
import com.teammokyuu.mc.vob.world.WorldProviderMirroredPlain;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
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
    
    public static int mirroredPlainDimID = -1;
    
	@SidedProxy(clientSide = "com.teammokyuu.mc.vob.client.ClientProxy", serverSide = "com.teammokyuu.mc.vob.CommonProxy")
	public static CommonProxy proxy;
    
	@Instance(MODID)
	public static Core instance;
 
    @EventHandler
    public void preInit( FMLPreInitializationEvent event ) {
    	File dir = new File( event.getModConfigurationDirectory( ), MODID + VERSION + ".cfg" );
    	Configuration c = new Configuration( dir );
    	
    	try {
    		c.load( );
    		mirroredPlainDimID = c.getInt( "dim_id", "", -1, -1, 255, "dimension id" );
    	}
    	catch( Exception e ) {
    		FMLLog.log( Level.INFO, e, "Error Loading mod config! This could result in an accidental duplicate dimension!" );
    	}
    	finally {
    		c.save( );
    	}
    	
    	if( mirroredPlainDimID == -1 )
    		mirroredPlainDimID = DimensionManager.getNextFreeDimId( );
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Blocks.setup( event.getSide( ) );
    	Items.setup( event.getSide( ) );
    	Recipes.setup( );
    	NetworkRegistry.INSTANCE.registerGuiHandler( instance, proxy );
    	Entities.setup( event.getSide( ) );
    	
    	// Mirrored Plain dimension loading
    	DimensionManager.registerProviderType( mirroredPlainDimID, WorldProviderMirroredPlain.class, false );
    	DimensionManager.registerDimension( mirroredPlainDimID, mirroredPlainDimID );
    	
    	// Event Handling
    	MinecraftForge.EVENT_BUS.register( new com.teammokyuu.mc.vob.EventHandler( ) );
    }
}
