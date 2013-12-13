package ghostmod.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		Boolean spawnGhosts = config.get("General", "spawnGhosts", true).getBoolean(true);
		Boolean spawnFriendlyGhosts = config.get("General", "spawnFriendlyGhosts", true).getBoolean(true);
		Boolean spawnMeanGhosts = config.get("General", "spawnMeanGhosts", true).getBoolean(true);
		
		config.save();
	}
}
