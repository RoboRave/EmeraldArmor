package com.dand0.ea;
 
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.village.MerchantRecipe;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import com.dand0.ea.ArmorTrading;
 
@Mod(modid="ea", version="1.0.0")
public class emeraldArmor {

	public static ArmorMaterial EmeraldArmorMaterial;
    
    public static ItemArmor emeraldHelmet;
    
    public static ItemArmor emeraldChest;
    
    public static ItemArmor emeraldLeggins;
    
    public static ItemArmor emeraldBoots;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	EmeraldArmorMaterial = EnumHelper.addArmorMaterial("EmeraldArmorMaterial", 3741, new int[] {746, 1076, 1010, 878}, 20);
    	
    	emeraldHelmet = (ItemArmor) new emeraldHelmet(3200, emeraldArmor.EmeraldArmorMaterial, 0, 0).setUnlocalizedName("emeraldHelmet");
    	GameRegistry.registerItem(emeraldHelmet, "emeraldHelmet");
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(emeraldArmor.emeraldHelmet, 1, 1/240, 1/240, 1));
    	// EntityVillager.blacksmithSellingList.put(emeraldArmor.emeraldHelmet, new Tuple(Integer.valueOf(3), Integer.valueOf(5)));
    	emeraldChest = (ItemArmor) new emeraldChest(emeraldArmor.EmeraldArmorMaterial, 1, 1).setUnlocalizedName("emeraldChest");
    	GameRegistry.registerItem(emeraldChest, "emeraldChest");
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(emeraldArmor.emeraldChest, 1, 1/240, 1/240, 1));
    	// EntityVillager.blacksmithSellingList.put(emeraldArmor.emeraldChest, new Tuple(Integer.valueOf(4), Integer.valueOf(8)));
    	emeraldLeggins = (ItemArmor) new emeraldLeggins(emeraldArmor.EmeraldArmorMaterial, 2, 2).setUnlocalizedName("emeraldLeggins");
    	GameRegistry.registerItem(emeraldLeggins, "emeraldLeggins");
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(emeraldArmor.emeraldLeggins, 1, 1/240, 1/240, 1));
    	// EntityVillager.blacksmithSellingList.put(emeraldArmor.emeraldLeggins, new Tuple(Integer.valueOf(4), Integer.valueOf(7)));
    	emeraldBoots = (ItemArmor) new emeraldBoots(emeraldArmor.EmeraldArmorMaterial, 3, 3).setUnlocalizedName("emeraldBoots");
    	GameRegistry.registerItem(emeraldBoots, "emeraldBoots");
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(emeraldArmor.emeraldBoots, 1, 1/240, 1/240, 1));
    	// EntityVillager.blacksmithSellingList.put(emeraldArmor.emeraldBoots, new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	VillagerRegistry.instance().registerVillageTradeHandler(3, ArmorTrading.INSTANCE.i);
    	ArmorTrading.INSTANCE.load();
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldChest), new Object[]{
    		"ABA",
    		"LLL",
    		"OOO",
    	    'A', Items.emerald, 'L', Items.emerald, 'O', Items.emerald
    	    });
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldLeggins), new Object[]{
    		"XXX", 
    		"F0F", 
    		"KOK",
    	    'X', Items.emerald, 'F', Items.emerald, 'K', Items.emerald
    	    });
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldHelmet), new Object[]{
    		"XXX", 
    		"F0F", 
    		"KOK",
    	    'X', Items.emerald, 'F', Items.emerald
    	    });
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldHelmet), new Object[]{
    		"XXX", 
    		"FFF", 
    		"KOK",
    	    'F', Items.emerald, 'K', Items.emerald
    	    });
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldBoots), new Object[]{
    		"X0X", 
    		"Y0Y", 
    		"ZOZ",
    	    'Y', Items.emerald, 'Z', Items.emerald
    	    });
    	
    	GameRegistry.addRecipe(new ItemStack(emeraldArmor.emeraldBoots), new Object[]{
    		"X0X", 
    		"Y0Y", 
    		"ZOZ",
    	    'X', Items.emerald, 'Y', Items.emerald
    	    });
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
    	
    }
}
