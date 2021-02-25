package com.niyanhhhhh.tfcintegration.core.handler;

import com.niyanhhhhh.tfcintegration.core.blocks.BlockBase;
import com.niyanhhhhh.tfcintegration.core.blocks.BlockReferences;
import com.niyanhhhhh.tfcintegration.core.items.ItemBase;
import com.niyanhhhhh.tfcintegration.core.items.ItemReferences;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegisterHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemReferences.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemReferences.ITEMS) {
            if (item instanceof ItemBase) {
                ((ItemBase) item).registerModels();
            }
        }
        for (Block block : BlockReferences.BLOCKS) {
            if (block instanceof BlockBase) {
                ((BlockBase) block).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockReferences.BLOCKS.toArray(new Block[0]));
    }

}
