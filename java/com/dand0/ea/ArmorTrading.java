package com.dand0.ea;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class ArmorTrading implements IVillageTradeHandler {

	public static final ArmorTrading INSTANCE = new ArmorTrading();
	
	public static EntityVillager villager;
	private static MerchantRecipeList merchantrecipelist;
	private Random rand;
	public IVillageTradeHandler i = this;
	 private float field_82191_bN;
	
	@Override
	public void manipulateTradesForVillager(EntityVillager villager,MerchantRecipeList recipeList, Random random){}
	
	public void load()
	{
		this.field_82191_bN = MathHelper.sqrt_float(1.0F) * 0.2F;
		this.rand = new Random();
		/** add methods here**/
		ArmorTrading.INSTANCE.addTradeItem(emeraldArmor.emeraldHelmet, rand, this.adjustProbability(0.5F));
	}

	public void addTradeItem(Item item, Random rand, float chance)
	{
		func_146089_b(merchantrecipelist, item, rand, chance);
	}
   
    @SuppressWarnings("unchecked")
	public static void func_146089_b(MerchantRecipeList p_146089_0_, Item p_146089_1_, Random p_146089_2_, float p_146089_3_)
    {
        if (p_146089_2_.nextFloat() < p_146089_3_)
        {
            int i = func_146090_c(p_146089_1_, p_146089_2_);
            ItemStack itemstack;
            ItemStack itemstack1;

            if (i < 0)
            {
                itemstack1 = new ItemStack(Items.emerald, 1, 0);
                itemstack = new ItemStack(p_146089_1_, -i, 0);
            }
            else
            {
                itemstack1 = new ItemStack(Items.emerald, i, 0);
                itemstack = new ItemStack(p_146089_1_, 1, 0);
            }

            p_146089_0_.add(new MerchantRecipe(itemstack, itemstack1));
        }
    }
    @SuppressWarnings("static-access")
	private static int func_146090_c(Item p_146090_0_, Random p_146090_1_)
    {
        Tuple tuple = (Tuple)villager.blacksmithSellingList.get(p_146090_0_);
        return tuple == null ? 1 : (((Integer)tuple.getFirst()).intValue() >= ((Integer)tuple.getSecond()).intValue() ? ((Integer)tuple.getFirst()).intValue() : ((Integer)tuple.getFirst()).intValue() + p_146090_1_.nextInt(((Integer)tuple.getSecond()).intValue() - ((Integer)tuple.getFirst()).intValue()));
    }
	private float adjustProbability(float par1)
    {
        float f1 = par1 + this.field_82191_bN;
        return f1 > 0.9F ? 0.9F - (f1 - 0.9F) : f1;
    }
  
       


}
