package net.mcreator.worldstudiosworld.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.worldstudiosworld.entity.LittlemanEntity;
import net.mcreator.worldstudiosworld.client.model.Modellittleman;

public class LittlemanRenderer extends MobRenderer<LittlemanEntity, LivingEntityRenderState, Modellittleman> {
	private final Identifier entityTexture = Identifier.parse("worldstudios_world:textures/entities/littleman.png");

	public LittlemanRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellittleman(context.bakeLayer(Modellittleman.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(LittlemanEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}