package ghostmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFriendlyGhost extends EntityGhost{

	protected EntityLivingBase player;
	public EntityFriendlyGhost(World world, EntityLivingBase entityLiving) {
		super(world);
		if (!(entityLiving instanceof EntityPlayer)) {
			throw new Exception();
		}
	}
}