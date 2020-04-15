package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class enderIngot extends Item {
	public enderIngot()
	{
		GameRegistry.registerItem(this, "enderIngot");
		setUnlocalizedName(Main.MODID + "_" + "enderIngot");
		setCreativeTab(CreativeTabs.tabMisc);
	}
}
