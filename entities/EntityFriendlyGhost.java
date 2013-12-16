package ghostmod.entities; 

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFriendlyGhost extends EntityGhost{

	public EntityPlayer player = null;
	
	public EntityFriendlyGhost(World world, EntityPlayer entity) {
		super(world);
		player = entity;
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