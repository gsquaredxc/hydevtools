package com.gsquaredxc.hydevtools;

import com.gsquaredxc.hydevtools.features.hdmining;
import com.gsquaredxc.hyskyAPI.eventListeners.EventRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = hydevtools.MODID,name = "hydevtools", version = hydevtools.VERSION,clientSideOnly = true)
public class hydevtools
{
    public static final String MODID = "hydevtools";
    public static final String VERSION = "1.0";

    
    @EventHandler
    public void preinit(final FMLPreInitializationEvent event)
    {
        System.out.println("does this even work?");
    }

    @EventHandler
    public void init(final FMLInitializationEvent event){
        System.out.println("catch me if you can motherfucker");
        EventRegister.register(hdmining.class);
    }
}
