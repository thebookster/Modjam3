package ghostmod.entities; 

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFriendlyGhost extends EntityGhost{

	protected EntityLivingBase player = null;
	public EntityFriendlyGhost(World world, EntityLivingBase entity) {
		super(world);
		if (entity instanceof EntityPlayer) {
			player = entity;
		}
	}
	public EntityFriendlyGhost(World world) {
		super(world);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && !entityplayer.equals(player) && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}
	
	@Override
	public void onUpdate() {
		if (this.entityToAttack != null && this.entityToAttack.equals(player)) {
			this.entityToAttack = null;
		}
		super.onUpdate();
	}
}