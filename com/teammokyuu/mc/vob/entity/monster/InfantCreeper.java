package com.teammokyuu.mc.vob.entity.monster;

import com.google.common.base.Predicate;

import com.teammokyuu.mc.vob.entity.ai.AIFollow;
import com.teammokyuu.mc.vob.entity.ai.AISwell;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class InfantCreeper extends CreeperBase {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InfantCreeper(World par1World)
	{
		super(par1World);
		this.tasks.taskEntries.clear( );
		
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AISwell(this));
		
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, new Predicate()
        {
            public boolean func_179958_a(Entity e )
            {
                return e instanceof EntityPlayer;
            }
            public boolean apply(Object p_apply_1_)
            {
                return this.func_179958_a((Entity)p_apply_1_);
            }
        }, 6.0F, 1.0D, 1.2D));
		
		this.tasks.addTask(4, new EntityAIAvoidEntity(this, new Predicate()
        {
            public boolean func_179958_a(Entity e )
            {
                return e instanceof EntitySkeleton || e instanceof EntityZombie;
            }
            public boolean apply(Object p_apply_1_)
            {
                return this.func_179958_a((Entity)p_apply_1_);
            }
        }, 6.0F, 1.0D, 1.2D));
		
		this.tasks.addTask(5, new AIFollow( this, 1.1D, EntityCreeper.class) );
		
		this.tasks.addTask(6, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		
		super.setExplosionCapacity( 1, 30 );
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue( 0.35D );
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue( 4.0D );
	}
	
	@Override
	protected float getSoundPitch( ) {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.7F;
	}

	@Override
	public float getExplosionPower( ) {
    	return 0.5F;
    }

	@Override
	public boolean getPowered()
	{
		return false;
	}

	@Override
	protected Item getDropItem()
	{
		return null;
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
	{
		this.attackEntityFrom( DamageSource.field_180137_b, 5.0F );
	}
}
