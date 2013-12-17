package ghostmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMeanGhost extends EntityGhost{

	
	public EntityMeanGhost(World world, String id) {
		super(world);
		player = id;
	}
	public EntityMeanGhost(World world) {
		super(world);
	}
	

}
