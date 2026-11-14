package net.mcreator.worldstudiosworld.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.worldstudiosworld.entity.CorpseEntity;
import net.mcreator.worldstudiosworld.client.model.Modelcorpse;

public class CorpseRenderer extends MobRenderer<CorpseEntity, LivingEntityRenderState, Modelcorpse> {
	private final Identifier entityTexture = Identifier.parse("worldstudios_world:textures/entities/corpse.png");

	public CorpseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcorpse(context.bakeLayer(Modelcorpse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(CorpseEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}