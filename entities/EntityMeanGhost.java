package ghostmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMeanGhost extends EntityGhost{

	protected EntityPlayer player = null;
	public EntityMeanGhost(World world, EntityPlayer entity) {
		super(world);
		player = entity;
	}
	public EntityMeanGhost(World world) {
		super(world);
	}
	
/*	@Override
	public void onUpdate() {
		if (player != null && this.canEntityBeSeen(player)) {
			this.entityToAttack = player;
		}
	}*/

}
