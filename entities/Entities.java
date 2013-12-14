package ghostmod.entities;

import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import ghostmod.GhostMod;
import ghostmod.config.ConfigHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityFriendlyGhost.class, "FriendlyGhost", ConfigHandler.FriendlyGhostID, GhostMod.instance, 80, 3, true);
		EntityList.IDtoClassMapping.put(ConfigHandler.friendlyGhostEggID, EntityFriendlyGhost.class);
		EntityList.entityEggs.put(ConfigHandler.friendlyGhostEggID, new EntityEggInfo(ConfigHandler.friendlyGhostEggID, 0, 0));
		
		EntityRegistry.registerModEntity(EntityMeanGhost.class, "MeanGhost", ConfigHandler.MeanGhostID, GhostMod.instance, 80, 3, true);
		EntityList.IDtoClassMapping.put(ConfigHandler.meanGhostEggID, EntityMeanGhost.class);
		EntityList.entityEggs.put(ConfigHandler.meanGhostEggID, new EntityEggInfo(ConfigHandler.meanGhostEggID, -1, -1));

	}
}