package ghostmod.entities;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityGhost extends EntityMob{
	
	private ItemStack[] equipment = new ItemStack[40];
    protected float[] equipmentDropChances = new float[40];

	public EntityGhost(World par1World) {
		super(par1World);
        for (int i = 0; i < this.equipmentDropChances.length; ++i)
        {
            this.equipmentDropChances[i] = 1.0F;
        }
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2D);

	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	
	

}
