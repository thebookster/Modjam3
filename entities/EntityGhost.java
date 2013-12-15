package ghostmod.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class EntityGhost extends EntityMob{
	
	private ItemStack[] carriedItems = new ItemStack[50];

	public EntityGhost(World par1World) {
		super(par1World);
		this.setCanPickUpLoot(true);
        for (int i = 0; i < this.equipmentDropChances.length; ++i)
        {
            this.equipmentDropChances[i] = 1.0F;
        }
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
		super.dropEquipment(par1, par2);
		for (int j = 0; j < getCarriedItems().length; ++j)
        {
            ItemStack itemstack = getCarriedItems()[j];
            boolean flag1 = true;

            if (itemstack != null) 
            {
                this.entityDropItem(itemstack, 0.0F);
            }
        }
	}

	public ItemStack[] getCarriedItems() {
		return carriedItems;
	}

	public void setCarriedItems(ItemStack[] carriedItems) {
		this.carriedItems = carriedItems;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();
        NBTTagCompound nbttagcompound1;

        for (int i = 0; i < this.carriedItems.length; ++i)
        {
            nbttagcompound1 = new NBTTagCompound();

            if (this.carriedItems[i] != null)
            {
                this.carriedItems[i].writeToNBT(nbttagcompound1);
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

            for (int i = 0; i < this.carriedItems.length; ++i)
            {
                this.carriedItems[i] = ItemStack.loadItemStackFromNBT((NBTTagCompound)nbttaglist.tagAt(i));
            }
        }
	}

	
	

}
