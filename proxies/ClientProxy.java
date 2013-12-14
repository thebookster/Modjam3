package ghostmod.proxies;

import ghostmod.config.ConfigHandler;
import ghostmod.entities.EntityFriendlyGhost;
import ghostmod.entities.EntityMeanGhost;
import ghostmod.entities.render.RenderFriendlyGhost;
import ghostmod.entities.render.RenderMeanGhost;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void initSounds() {
		//init all sounds
	}
	
	@Override
	public void initRenderers() {
		if (ConfigHandler.spawnFriendlyGhosts = true) {
			RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyGhost.class, new RenderFriendlyGhost());
		}
		
		if (ConfigHandler.spawnMeanGhosts = true) {
			RenderingRegistry.registerEntityRenderingHandler(EntityMeanGhost.class, new RenderMeanGhost());
		}
	}
}
