package com.teammokyuu.mc.vob.entity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class InfantCreeperModel extends ModelBase
{
	//fields
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer tail;
		ModelRenderer tail2;
		ModelRenderer leg3;
		ModelRenderer leg4;
		ModelRenderer leg1;
		ModelRenderer leg2;
	
	public InfantCreeperModel()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -7F, -7F, 8, 8, 8);
		head.setRotationPoint(0F, 17F, -3F);
		head.setTextureSize(64, 32);
		head.mirror = true;

		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, -1F, -4F, 8, 8, 4);
		body.setRotationPoint(0F, 16F, -2F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		
		tail = new ModelRenderer(this, 32, 0);
		tail.addBox(-1F, -1F, 0F, 2, 2, 4);
		tail.setRotationPoint(0F, 18F, 5F);
		tail.setTextureSize(64, 32);
		tail.mirror = true;
		
		tail2 = new ModelRenderer(this, 32, 0);
		tail2.addBox(-1F, -1F, 0F, 2, 2, 2);
		tail2.setRotationPoint(0F, 19F, 9F);
		tail2.setTextureSize(64, 32);
		tail2.mirror = true;
		
		leg3 = new ModelRenderer(this, 0, 18);
		leg3.addBox(-2F, 0F, -2F, 4, 4, 4);
		leg3.setRotationPoint(-4F, 20F, 0F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		leg3.rotateAngleZ = 0.2617994F;
		
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(-2F, 0F, -2F, 4, 4, 4);
		leg4.setRotationPoint(4F, 20F, 0F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		leg4.rotateAngleZ = -0.2617994F;
		
		leg1 = new ModelRenderer(this, 0, 18);
		leg1.addBox(-2F, 0F, -2F, 4, 4, 4);
		leg1.setRotationPoint(-4F, 20F, 4F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		leg1.rotateAngleZ = 0.2617994F;
		
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(-2F, 0F, -2F, 4, 4, 4);
		leg2.setRotationPoint(4F, 20F, 4F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		leg2.rotateAngleZ = -0.2617994F;
	}
	
	public void render( Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7 ) {
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		this.head.render(par7);
		this.body.render(par7);
		this.leg1.render(par7);
		this.leg2.render(par7);
		this.leg3.render(par7);
		this.leg4.render(par7);
		this.tail.render(par7);
		this.tail2.render(par7);
	}
	
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		this.body.rotateAngleX = 1.48353F;
	
		this.leg1.rotateAngleX = 0.2617994F;
		this.leg2.rotateAngleX = 0.2617994F;
		this.leg3.rotateAngleX = -0.2617994F;
		this.leg4.rotateAngleX = -0.2617994F;
		
		this.tail.rotateAngleX = -0.2617994F;
		this.tail2.rotateAngleX = 0.2094395F;
	
		this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
		this.leg1.rotateAngleX += MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.rotateAngleX += MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.leg3.rotateAngleX += MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.leg4.rotateAngleX += MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}

}
