package ghostmod.entities; 

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFriendlyGhost extends EntityGhost{

	public EntityFriendlyGhost(World world, String id) {
		super(world);
		player = id;
	}
	public EntityFriendlyGhost(World world) {
		super(world);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && !entityplayer.getEntityName().equals(player) && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}
	
	@Override
	public void onUpdate() {
		if (this.entityToAttack != null && this.entityToAttack.getEntityName().equals(player)) {
			this.entityToAttack = null;
		}
		super.onUpdate();
	}
}