package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;;

public class BlockJadeOre extends Block {
	String name = "jadeOre";
	public BlockJadeOre() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
        setUnlocalizedName(Main.MODID + "_" + name);
        
        setHardness(2.5F);
        setResistance(10.5F);
        setStepSound(soundTypeMetal);
        setHarvestLevel("pickaxe", 3);
        
        setCreativeTab(CreativeTabs.tabBlock);
 }

	public String getName()
	{
        return name;
	}
}
