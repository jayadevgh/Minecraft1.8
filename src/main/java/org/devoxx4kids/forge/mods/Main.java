package org.devoxx4kids.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	myEventHandler handler = new myEventHandler();
    public static final String MODID = "myMods";
    public static final String VERSION = "1.0";
    public static Block enderBlock;
    public static Item enderIngot;
    public static Item berry;
    public static Block jadeOre;
    public static Item key;
    public static Item magmaIngot;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	enderIngot = new enderIngot();
    	key = new ItemKey();
    	jadeOre = new BlockJadeOre();
    	GameRegistry.registerWorldGenerator(handler, 0);
    	magmaIngot = new ItemMagmaIngot();
    	OreDictionary.registerOre("ingotMagma", new ItemStack(magmaIngot));
    	EntityRegistry.registerModEntity(EntityJayMob.class, "jaymob", 0, this, 80, 3, true);
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
    	//MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
    	MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
    	MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosion());
    	MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
    	//MinecraftForge.EVENT_BUS.register(new CreeperReinforcements());
    	MinecraftForge.EVENT_BUS.register(new ZombieKnight());
    	MinecraftForge.EVENT_BUS.register(new Parachutes());
    	//MinecraftForge.EVENT_BUS.register(new SuperJump());
    	//MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
    	//MinecraftForge.EVENT_BUS.register(new ());
    	//MinecraftForge.EVENT_BUS.register(new ());
    	//MinecraftForge.EVENT_BUS.register(new ());
    	enderBlock = new EnderBlock(); 
    	GameRegistry.registerBlock(enderBlock, "enderBlock"); 
    	GameRegistry.addRecipe( 
    			new ItemStack(Blocks.cobblestone), 
    			"dd", 
    			"dd",
    			'd', Blocks.dirt);
    	GameRegistry.addRecipe( 
    			new ItemStack(enderBlock), 
    			"iii", 
    			"iii",
    			"iii",
    			'i', enderIngot);
    	GameRegistry.addRecipe( 
    			new ItemStack(enderBlock), 
    			"e e", 
    			" o ",
    			"e e",
    			'o', Blocks.obsidian,
    			'e', Items.ender_eye);
    	GameRegistry.addShapelessRecipe( 
    			new ItemStack(enderIngot, 9), 
    			new ItemStack(enderBlock));
    	GameRegistry.addShapelessRecipe(
    			new ItemStack(enderIngot, 12),
    			new ItemStack(enderBlock, 1),
    			new ItemStack(Items.gold_ingot),
    			new ItemStack(Items.iron_ingot));
    	GameRegistry.addSmelting(
    			Blocks.gravel, 
    			new ItemStack(Items.flint, 1), 
    			1.0F);
    	Items.cake.setPotionEffect(PotionHelper.blazePowderEffect 
    			+
    			"+6" 
    			+ 
    			"+14");
        ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
        enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);

        GameRegistry.addShapelessRecipe(enchantedSwordItemStack, Items.flint, Items.stone_sword);

        ItemStack knockbackItemStack = new ItemStack(Items.stone_sword);
        knockbackItemStack.addEnchantment(Enchantment.knockback, 1);

        GameRegistry.addShapelessRecipe(knockbackItemStack, Items.gunpowder, Items.stone_sword );

        // smelting
        GameRegistry.addSmelting(Blocks.stone, new ItemStack(Blocks.stonebrick), 0.1F);

        // dungeon changes
        DungeonHooks.removeDungeonMob("Spider");
        DungeonHooks.addDungeonMob("Creeper", 100);
        ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.saddle));
        ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.cobblestone), 25, 50, 10));
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

    		renderItem.getItemModelMesher().register(key, 0, new 
    				ModelResourceLocation(MODID + ":" + "key", "inventory"));
    		
    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(jadeOre), 0, new 
    				ModelResourceLocation(MODID + ":" + ((BlockJadeOre) jadeOre).getName(), "inventory"));
        	
    		renderItem.getItemModelMesher().register(magmaIngot, 0, new 
    				ModelResourceLocation(MODID + ":" + "magmaIngot", "inventory"));
    		
    		Item enderBlockItem = GameRegistry.findItem("mymods", "enderBlock"); 
        	ModelResourceLocation enderBlockModel =
        		new ModelResourceLocation("mymods:enderBlock", "inventory"); 
        	renderItem.getItemModelMesher()
        		.register(enderBlockItem, 0, enderBlockModel); 
        	
        	renderItem.getItemModelMesher().register(enderIngot, 0, new
        			ModelResourceLocation(MODID + ":" + enderIngot, "inventory"));
    	} 
    	
    }
}
