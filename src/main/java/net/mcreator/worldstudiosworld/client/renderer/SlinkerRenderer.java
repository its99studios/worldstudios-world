package net.mcreator.worldstudiosworld.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.worldstudiosworld.entity.SlinkerEntity;
import net.mcreator.worldstudiosworld.client.model.Modelslinker;

public class SlinkerRenderer extends MobRenderer<SlinkerEntity, LivingEntityRenderState, Modelslinker> {
	private final Identifier entityTexture = Identifier.parse("worldstudios_world:textures/entities/shulker.png");

	public SlinkerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelslinker(context.bakeLayer(Modelslinker.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(SlinkerEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}