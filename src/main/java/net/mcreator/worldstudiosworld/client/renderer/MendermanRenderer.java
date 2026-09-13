package net.mcreator.worldstudiosworld.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.worldstudiosworld.entity.MendermanEntity;
import net.mcreator.worldstudiosworld.client.model.Modelmenderman;

public class MendermanRenderer extends MobRenderer<MendermanEntity, LivingEntityRenderState, Modelmenderman> {
	private final Identifier entityTexture = Identifier.parse("worldstudios_world:textures/entities/enderman.png");

	public MendermanRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmenderman(context.bakeLayer(Modelmenderman.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(MendermanEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}