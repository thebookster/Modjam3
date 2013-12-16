package ghostmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityExtra extends EntityGhost{

	protected EntityPlayer player = null;
	public EntityExtra(World world, EntityPlayer entity) {
		super(world);
		player = entity;
	}
	public EntityExtra(World world) {
		super(world);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(2D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(4D);

	}
	
	
/*	@Override
	public void onUpdate() {
		if (player != null && this.canEntityBeSeen(player)) {
			this.entityToAttack = player;
		}
	}*/

}
