package com.niyanhhhhh.tfcintegration.core.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Map;

public class CommonProxy {

    public CommonProxy() {
    }

    public CommonProxy(String modName) {
        ProxyReferences.proxies.put(modName, this);
    }

    public void preInit(FMLPreInitializationEvent event) {
        for (Map.Entry<String, CommonProxy> entry : ProxyReferences.proxies.entrySet()) {
            if (Loader.isModLoaded(entry.getKey())) {
                entry.getValue().preInit(event);
            }
        }
    }

    public void init(FMLInitializationEvent event) {
        for (Map.Entry<String, CommonProxy> entry : ProxyReferences.proxies.entrySet()) {
            if (Loader.isModLoaded(entry.getKey())) {
                entry.getValue().init(event);
            }
        }
    }

    public void postInit(FMLPostInitializationEvent event) {
        for (Map.Entry<String, CommonProxy> entry : ProxyReferences.proxies.entrySet()) {
            if (Loader.isModLoaded(entry.getKey())) {
                entry.getValue().postInit(event);
            }
        }
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

}
