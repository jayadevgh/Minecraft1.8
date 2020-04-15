package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemMagmaIngot extends Item {
	public ItemMagmaIngot()
    {
           GameRegistry.registerItem(this, "magmaIngot");
           setUnlocalizedName(Main.MODID + "_" + "magmaIngot");
           setCreativeTab(CreativeTabs.tabMisc);
    }
}
