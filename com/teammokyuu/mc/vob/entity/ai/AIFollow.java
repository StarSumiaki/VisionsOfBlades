package com.teammokyuu.mc.vob.entity.ai;

import java.util.Iterator;
import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class AIFollow extends EntityAIBase
{
	/** The child that is following its parent. */
	EntityCreature follower;
	EntityLivingBase target;
	double field_75347_c;
	private int field_75345_d;
	
	Class<? extends EntityLivingBase>[] validClasses;

	public AIFollow(EntityCreature e, double par2, Class<? extends EntityLivingBase> ... c )
	{
		this.follower = e;
		this.field_75347_c = par2;
		this.validClasses = c;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@SuppressWarnings("unchecked")
	public boolean shouldExecute()
	{
		ArrayList<Entity> list = new ArrayList<Entity>( );
		for( Class<? extends EntityLivingBase> c : this.validClasses )
			list.addAll( this.follower.worldObj.getEntitiesWithinAABB( c, this.follower.getEntityBoundingBox( ).expand(8.0D, 4.0D, 8.0D)) );
		
		EntityLivingBase ec = null;
		
		double d0 = Double.MAX_VALUE;
		Iterator<Entity> iterator = list.iterator();

		while( iterator.hasNext( ) ) {
			EntityLivingBase ec2 = (EntityLivingBase)iterator.next();
			double d1 = this.follower.getDistanceSqToEntity( ec2 );
			if (d1 <= d0) {
				d0 = d1;
				ec = ec2;
			}
		}

		if( ec == null )
			return false;
		else if( d0 < 9.0D )
			return false;
		else {
			this.target = ec;
			return true;
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		if( !this.target.isEntityAlive( ) )
			return false;
		else
		{
			double d0 = this.follower.getDistanceSqToEntity(this.target);
			return d0 >= 9.0D && d0 <= 256.0D;
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.field_75345_d = 0;
	}

	/**
	 * Resets the task
	 */
	public void resetTask()
	{
		this.target = null;
	}

	/**
	 * Updates the task
	 */
	public void updateTask()
	{
		if (--this.field_75345_d <= 0)
		{
			this.field_75345_d = 10;
			this.follower.getNavigator().tryMoveToEntityLiving(this.target, this.field_75347_c);
		}
	}
}