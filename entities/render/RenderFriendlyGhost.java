package ghostmod.entities.render;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFriendlyGhost extends RenderLiving {
	
	public RenderFriendlyGhost()
	{
        super(new ModelZombie(), 0.5F);
		this.shadowSize *= 0.0F;
	}
	
	@Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("textures/entity/zombie/zombie.png");
	}

}
