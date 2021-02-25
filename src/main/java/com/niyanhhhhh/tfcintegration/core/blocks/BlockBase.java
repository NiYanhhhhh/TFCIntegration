package com.niyanhhhhh.tfcintegration.core.blocks;

import com.niyanhhhhh.tfcintegration.core.TIMain;
import com.niyanhhhhh.tfcintegration.core.items.ItemReferences;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Loader;

public class BlockBase extends Block {

    public String parent;

    public BlockBase(String name, Material material) {
        this(name, material, "core");
    }

    public BlockBase(String name, Material material, String parent) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TIMain.CT_INTEGRATION);

        this.parent = parent;
        if (parent == "core" || Loader.isModLoaded(parent)) {
            BlockReferences.BLOCKS.add(this);
            ItemReferences.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

    public void registerModels() {
        TIMain.tiProxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
