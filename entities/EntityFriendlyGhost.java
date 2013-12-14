package ghostmod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFriendlyGhost extends EntityGhost{

	protected EntityLivingBase player = null;
	public EntityFriendlyGhost(World world) {
		super(world);
		
	}
	
	@Override
	protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && !entityplayer.equals(player) && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}
}