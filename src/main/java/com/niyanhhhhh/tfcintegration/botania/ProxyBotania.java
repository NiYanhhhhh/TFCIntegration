package com.niyanhhhhh.tfcintegration.botania;

import com.google.common.collect.BiMap;
import com.niyanhhhhh.tfcintegration.botania.blocks.SubtileCustomGourmaryllis;
import com.niyanhhhhh.tfcintegration.core.TIMain;
import com.niyanhhhhh.tfcintegration.core.proxies.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.common.lib.LibBlockNames;

import java.lang.reflect.Field;

public class ProxyBotania extends CommonProxy {

    public ProxyBotania() {
        super("botania");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        TIMain.LOGGER.info("bot init.");
        registerOverride();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerOverride() {
        final BiMap<String, Class<? extends SubTileEntity>> subTiles;
        try {
            Field field = BotaniaAPI.class.getDeclaredField("subTiles");
            field.setAccessible(true);
            subTiles = (BiMap<String, Class<? extends SubTileEntity>>) field.get(null);

            if (subTiles != null) {
                subTiles.forcePut(LibBlockNames.SUBTILE_GOURMARYLLIS, SubtileCustomGourmaryllis.class);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
