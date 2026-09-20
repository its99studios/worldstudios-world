// Made with Blockbench 5.2.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelslinker<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "slinker"), "main");
	private final ModelPart lid;
	private final ModelPart head;

	public Modelslinker(ModelPart root) {
		this.lid = root.getChild("lid");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lid = partdefinition.addOrReplaceChild("lid",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -38.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(37, 28)
						.addBox(-8.0F, -30.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(37, 28)
						.addBox(7.0F, -30.0F, -1.0F, 1.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = lid
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(37, 28).addBox(0.0F, -22.0F, -1.0F, 1.0F, 22.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, -8.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = lid.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(37, 28).addBox(0.0F, -22.0F, -1.0F, 1.0F, 22.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(
				-3.0F, -10.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		lid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.xRot = netHeadYaw / (180F / (float) Math.PI);
		this.lid.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.lid.xRot = headPitch / (180F / (float) Math.PI);
	}
}