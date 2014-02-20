package com.dand0.ea;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class ArmorTrading implements IVillageTradeHandler {

	public static ArmorTrading INSTANCE = new ArmorTrading();
	
	public void load()
	{
		VillagerRegistry.instance().registerVillageTradeHandler(1, this);
		VillagerRegistry.instance().registerVillageTradeHandler(2, this);
	}
	
	@Override
	public void manipulateTradesForVillager(EntityVillager villager,
			MerchantRecipeList recipeList, Random random) {
		switch (villager.getProfession()) {
		case 3:
			manipulateBlacksmithTrades(recipeList);
			break;
	}
		
	}
	
	private void manipulateBlacksmithTrades(MerchantRecipeList recipeList)
	{
		Item itemMain = Values.itemMain;
		if (itemMain != null) {
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 3 | 5), new ItemStack(itemMain, 1, 11)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald), new ItemStack(itemMain, 1, 15)));
		}
	}

}
