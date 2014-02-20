package com.dand0.ea;

import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class emeraldLeggins extends ItemArmor
{
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return true;
	}
	
	public final int armorType() {
		return 2;
	}

	public emeraldLeggins(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	/*
	 * Иконка
	 */
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon("ea:emeraldLeggins"); 
	}
	
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		/*
		 * Любой эффект, когда броня одета (не вся, а только определенный предмет(в данном случае - шлем))
		 */
    }
	
	/*
	 * Текстура брони на игроке
	 */
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
		return "ea:textures/models/armor/EmeraldArmor.png";
    }

}