package ghostmod.eventhandlers;

import ghostmod.entities.EntityFriendlyGhost;
import ghostmod.entities.EntityGhost;
import ghostmod.entities.EntityMeanGhost;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EventHookContainer {

	@ForgeSubscribe
	public void livingDropsEvent(LivingDropsEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityGhost ghost; 
			Random rand = new Random();
			if (rand.nextInt(2) == 0) {
				ghost = new EntityFriendlyGhost(event.entityLiving.worldObj, event.entityLiving);
			} else {
				ghost = new EntityMeanGhost(event.entityLiving.worldObj, event.entityLiving);
			}
			ghost.setPositionAndUpdate(event.entityLiving.posX, event.entityLiving.posY+3, event.entityLiving.posZ);
/*			ArrayList<EntityItem> drops = event.drops;
			for (int i = 0; i < drops.size(); i++) {
				ghost.getCarriedItems()[i] = drops.get(i).getEntityItem();
			}
			event.drops.clear();*/
			if (!event.entityLiving.worldObj.isRemote) {
				event.entityLiving.worldObj.spawnEntityInWorld(ghost);
				
			}

		}
	}
	
	
}