package com.niyanhhhhh.tfcintegration.core;

import com.niyanhhhhh.tfcintegration.core.proxies.CommonProxy;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = TIMain.MODID,
        acceptedMinecraftVersions = TIMain.MC_VERSION,
        dependencies = TIMain.DEPENDENCIES,
        useMetadata = true
)
public class TIMain {

    public static final String MC_VERSION = "[1.12.2]";
    public static final String MODID = "tfcintegration";
    public static final String DEPENDENCIES = "required-after:tfc;before:botania";
    public static final String TABNAME = "tfcintegration";
    public static final String CLIENT_PROXY_CLASS = "com.niyanhhhhh.tfcintegration.core.proxies.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.niyanhhhhh.tfcintegration.core.proxies.CommonProxy";

    @Instance(MODID)
    public static TIMain instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy tiProxy;

    public final static Logger LOGGER = LogManager.getLogger(MODID);

    public static final CreativeTabs CT_INTEGRATION = new CreativeTabs(TABNAME) {

        // This method is copied from net.dries007.tfc.objects.CreativeTabsTFC.TFCCreativeTab. It's a private class
        @Override
        public ItemStack createIcon() {
            ItemStack stack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tfc:metal/chisel/red_steel")));
            if (!stack.isEmpty()) {
                CapabilityFood.setStackNonDecaying(stack);
                return stack;
            } else {
                LOGGER.error("[Please inform developers] No icon stack for creative tab {}", getTabLabel());
                return new ItemStack(Items.STICK);
            }
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tiProxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        tiProxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        tiProxy.postInit(event);
    }

}
