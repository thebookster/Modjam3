package ghostmod.entities;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityGhost extends EntityMob{

	public EntityGhost(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2D);
	}
	

}
