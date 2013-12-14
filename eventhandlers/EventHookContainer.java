package ghostmod.eventhandlers;

import ghostmod.entities.EntityFriendlyGhost;
import ghostmod.entities.EntityGhost;
import ghostmod.entities.EntityMeanGhost;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EventHookContainer {

	@ForgeSubscribe
	public void onDeath(LivingDeathEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			Random rand = new Random();
			if (rand.nextInt(2) == 0) {
				EntityFriendlyGhost ghost = new EntityFriendlyGhost(event.entityLiving.worldObj, event.entityLiving);
				ghost.setPositionAndUpdate(event.entityLiving.posX, event.entityLiving.posY+3, event.entityLiving.posZ);
				if (!event.entityLiving.worldObj.isRemote) {
					event.entityLiving.worldObj.spawnEntityInWorld(ghost);
				}
			} else {
				EntityMeanGhost ghost = new EntityMeanGhost(event.entityLiving.worldObj, event.entityLiving);
				ghost.setPositionAndUpdate(event.entityLiving.posX, event.entityLiving.posY+3, event.entityLiving.posZ);
				if (!event.entityLiving.worldObj.isRemote) {
					event.entityLiving.worldObj.spawnEntityInWorld(ghost);
				}
			}


		}
	}
}