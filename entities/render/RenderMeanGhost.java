package ghostmod.entities.render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMeanGhost extends RenderLiving {

	public RenderMeanGhost()
	{

        super(new ModelZombie(), 0.5F);
		this.shadowSize *= 0.0F;
	}


	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("ghostmod:textures/meanGhost.png");
	}

}