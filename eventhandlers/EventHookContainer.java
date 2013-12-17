package ghostmod.eventhandlers;

import ghostmod.entities.EntityExtra;
import ghostmod.entities.EntityFriendlyGhost;
import ghostmod.entities.EntityGhost;
import ghostmod.entities.EntityMeanGhost;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EventHookContainer {

	protected void equipBestArmorAndWeapon (ArrayList<EntityItem> drops, EntityGhost ghost) {
		ItemStack[] result = new ItemStack[5];
		for (int i = 0; i < drops.size(); i++) {
			if (drops.get(i) != null) {
				ItemStack itemstack = drops.get(i).getEntityItem();
				Item item = itemstack.getItem();
				if (item != null) {
					if (item instanceof ItemSword) {
						ItemSword sword = (ItemSword)item;
						if (sword.func_82803_g() > ((ItemSword)result[0].getItem()).func_82803_g()) {
							result[0] = itemstack;
						}
					else if (item instanceof ItemArmor) {
						ItemArmor armor = (ItemArmor)item;
						switch (armor.armorType) {
						case 0: if (armor.damageReduceAmount > ((It))
						}
					}
				        
						
					}
				}
			}
		}
		
	}
	
	@ForgeSubscribe
	public void livingDropsEvent(LivingDropsEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityGhost ghost; 
			Random rand = new Random();
			if (rand.nextInt(2) == 0) {
				ghost = new EntityFriendlyGhost(event.entityLiving.worldObj, (EntityPlayer)event.entityLiving);
			} else if (rand.nextInt(1000) == 666) {
				ghost = new EntityExtra(event.entityLiving.worldObj, (EntityPlayer)event.entityLiving);
			} else {
				ghost = new EntityMeanGhost(event.entityLiving.worldObj, (EntityPlayer)event.entityLiving);
			}
			ghost.setPositionAndUpdate(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
			ArrayList<EntityItem> drops = event.drops;
			for (int i = 0; i < drops.size(); i++) {
				ghost.getCarriedItems().set(i, drops.get(i).getEntityItem());
			}
			event.drops.clear();
			if (!event.entityLiving.worldObj.isRemote) {
				event.entityLiving.worldObj.spawnEntityInWorld(ghost);
				
			}

		}
	}
	
	@ForgeSubscribe
	public void entityAttack(AttackEntityEvent event) {
		if (event.target instanceof EntityFriendlyGhost) {
			EntityFriendlyGhost ghost = (EntityFriendlyGhost)event.target;
			if (ghost.player != null && ghost.player.getEntityName() == event.entityPlayer.getEntityName()) {
				ghost.killGhost();
			}
		}
	}
	
	
}