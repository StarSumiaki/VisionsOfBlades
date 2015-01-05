package com.teammokyuu.mc.vob.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class SwordBase extends ItemSelfLiaison {

	private SwordType type;
	
	public SwordBase( SwordType type ) {
		this.type = type;
		this.maxStackSize = 1;
        this.setMaxDamage( type.durability );
        this.setCreativeTab( CreativeTabs.tabCombat );
        // Because doing it in the superconstructor leads to order-of-instructions NPE > . >
        super.setUnlocalizedName( this.getRawName( ) );
	}

	/* ----- BEGIN ItemSelfLiaison ----- */
	
	@Override
	public String getRawName() {
		return this.type.rawName;
	}
	
	/* ---- BEGIN Item ----- */
	
	@Override
	public float getStrVsBlock( ItemStack stack, Block block ) {
		if( this.canHarvestBlock( block ) )
			return 15.0F;
		else {
			Material m = block.getMaterial();
			return m == Material.plants || m == Material.vine || m == Material.coral || m == Material.leaves || m == Material.gourd ? 
					1.5F :
					1.0F;
		}
	}

	@Override
	public boolean hitEntity( ItemStack stack, EntityLivingBase target, EntityLivingBase attacker ) {
		stack.damageItem(1, attacker);
		return true;
	}

	@Override
	public boolean onBlockDestroyed( ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase player ) {
		if( block.getBlockHardness(world, pos) != 0F )
			stack.damageItem(2, player);
		return true;
	}

	@Override
	public boolean isFull3D( ) {
		return true;
	}

	@Override
	public EnumAction getItemUseAction( ItemStack stack ) {
		return EnumAction.BLOCK;
	}

	@Override
	public int getMaxItemUseDuration( ItemStack stack ) {
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick( ItemStack stack, World world, EntityPlayer player ) {
		player.setItemInUse( stack, this.getMaxItemUseDuration( stack ) );
		return stack;
	}

	@Override
	public boolean canHarvestBlock( Block block ) {
		return block == Blocks.web;
	}

	@Override
	public int getItemEnchantability( ) {
		return this.type.repairMaterial.getEnchantability( );
	}
	
	public boolean getIsRepairable( ItemStack toRepair, ItemStack repair ) {
		ItemStack mat = this.type.repairMaterial.getRepairItemStack();
		if( mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches( mat, repair, false ) )
			return true;
		return super.getIsRepairable( toRepair, repair );
	}
	
	@Override
	public Multimap< String, AttributeModifier > getAttributeModifiers(ItemStack stack) {
		HashMultimap< String, AttributeModifier > map = HashMultimap.create( );
		map.put(
				SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName( ),
				new AttributeModifier( Item.itemModifierUUID, "Weapon modifier", (double)this.type.baseDamage, 0 ) );
		return map;
	}

}
