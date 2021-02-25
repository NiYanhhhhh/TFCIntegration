package com.niyanhhhhh.tfcintegration.core.items;

import com.niyanhhhhh.tfcintegration.core.TIMain;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public String parent;

    public ItemBase(String name, String parent) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(TIMain.CT_INTEGRATION);

        this.parent = parent;
        ItemReferences.ITEMS.add(this);
    }

    public void registerModels() {
        TIMain.tiProxy.registerItemRenderer(this, 0, "inventory");
    }

}
