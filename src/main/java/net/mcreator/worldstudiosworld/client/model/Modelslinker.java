package net.mcreator.worldstudiosworld.client.model;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.2.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelslinker extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("worldstudios_world", "modelslinker"), "main");
	public final ModelPart lid;
	public final ModelPart head;

	public Modelslinker(ModelPart root) {
		super(root);
		this.lid = root.getChild("lid");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition lid = partdefinition
				.addOrReplaceChild(
						"lid", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -38.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F))
								.texOffs(37, 28).addBox(-8.0F, -30.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(37, 28).addBox(7.0F, -30.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = lid.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(37, 28).addBox(0.0F, -22.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 8.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r2 = lid.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(37, 28).addBox(0.0F, -22.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.0F, -7.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

		this.head.xRot = netHeadYaw / (180F / (float) Math.PI);
		this.lid.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.lid.xRot = headPitch / (180F / (float) Math.PI);
	}
}