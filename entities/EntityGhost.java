package ghostmod.entities;

import java.util.ArrayList;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;


public class EntityGhost extends EntityMob{
	
	public String player = null;
	
	private ArrayList<ItemStack> carriedItems = new ArrayList();

	public EntityGhost(World par1World) {
		super(par1World);
		this.setCanPickUpLoot(true);
        for (int i = 0; i < this.equipmentDropChances.length; ++i)
        {
            this.equipmentDropChances[i] = 1.0F;
        }
        this.isImmuneToFire = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(1D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(2D);

	}
	
	@Override
	protected boolean canDespawn() {
		return this.entityAge > 1200;
	}
	
	@Override
	protected void dropEquipment(boolean par1, int par2) {
		ArrayList<ItemStack> carriedItems = getCarriedItems();
		if (carriedItems != null) {
			for (int j = 0; j < carriedItems.size(); ++j)
	        {
	            ItemStack itemstack = carriedItems.get(j);
	            boolean flag1 = true;
	
	            if (itemstack != null) 
	            {
	                this.entityDropItem(itemstack, 0.0F);
	            }
	        }
		}
		ItemStack[] equipment = this.getLastActiveItems();
		if (equipment != null) {
			for (int j = 0; j < equipment.length; ++j)
	        {
	            ItemStack itemstack = equipment[j];
	            boolean flag1 = true;
	
	            if (itemstack != null) 
	            {
	                this.entityDropItem(itemstack, 0.0F);
	            }
	        }
		}
		
	}

	public ArrayList<ItemStack> getCarriedItems() {
		return carriedItems;
	}

	public void setCarriedItems(ArrayList<ItemStack> carriedItems) {
		this.carriedItems = carriedItems;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setString("player", player);
        NBTTagList nbttaglist = new NBTTagList();
        NBTTagCompound nbttagcompound1;

        for (int i = 0; i < this.carriedItems.size(); ++i)
        {
            nbttagcompound1 = new NBTTagCompound();

            if (this.carriedItems.get(i) != null)
            {
                this.carriedItems.get(i).writeToNBT(nbttagcompound1);
            }

            nbttaglist.appendTag(nbttagcompound1);
        }

        par1NBTTagCompound.setTag("CarriedItems", nbttaglist);
		
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist;
        if (par1NBTTagCompound.hasKey("CarriedItems"))
        {
            nbttaglist = par1NBTTagCompound.getTagList("CarriedItems");

            for (int i = 0; i < this.carriedItems.size(); ++i)
            {
                this.carriedItems.add(i, ItemStack.loadItemStackFromNBT((NBTTagCompound)nbttaglist.tagAt(i)));
            }
        }
        if (par1NBTTagCompound.hasKey(player)) {
        	this.player = par1NBTTagCompound.getString("player");
        }
	}
	
	public void killGhost() {
		this.dropEquipment(false, 1);
		this.setDead();
	}

	
	

}
