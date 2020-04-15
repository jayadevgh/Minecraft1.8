package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemKey extends Item {
	public ItemKey()
	{
		GameRegistry.registerItem(this, "key");
		setUnlocalizedName(Main.MODID + "_" + "key");
		setCreativeTab(CreativeTabs.tabMisc);
	}
}
