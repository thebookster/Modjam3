package ghostmod.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static Boolean spawnGhosts;
	public static Boolean spawnFriendlyGhosts;
	public static int friendlyGhostEggID;
	public static Boolean spawnMeanGhosts;
	public static int meanGhostEggID;
	
	public static int FriendlyGhostID;
	public static int MeanGhostID;
	
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		spawnGhosts = config.get("General", "spawnGhosts", true).getBoolean(true);
		spawnFriendlyGhosts = config.get("General", "spawnFriendlyGhosts", true).getBoolean(true);
		friendlyGhostEggID = config.get("General", "friendlyGhostEgg", 100).getInt();
		
		spawnMeanGhosts = config.get("General", "spawnMeanGhosts", true).getBoolean(true);
		meanGhostEggID = config.get("General",  "meanGhostEgg",  101).getInt();
		
		FriendlyGhostID = config.get("IDs", "friendlyGhost", 100).getInt();
		MeanGhostID = config.get("IDs", "meanGhost", 101).getInt();
		
		config.save();
	}
}
