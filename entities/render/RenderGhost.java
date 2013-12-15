package ghostmod.entities.render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGhost extends RenderBiped {

	private static Entity player;
	
	public RenderGhost()
	{
        super(new ModelZombie(), 0.5F);;
		//this.bindEntityTexture(getPlayer());
	}

	public Entity getPlayer() {
		return player;
	}

	public static void setPlayer(Entity entity) {
		player = entity;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("ghostmod:textures/meanghost.png");
	}


}