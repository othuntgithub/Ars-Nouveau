package com.hollingsworth.arsnouveau.client.renderer.tile;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class EnchantingApparatusModel extends Model {
    public final ModelRenderer frame_all;
    private final ModelRenderer cap_top;
    public final ModelRenderer cap_bot;
    public final ModelRenderer frame_top;
    private final ModelRenderer frame_top1;
    private final ModelRenderer frame_top2;
    private final ModelRenderer frame_top3;
    private final ModelRenderer frame_top4;
    public final ModelRenderer frame_bot;
    private final ModelRenderer frame_bot1;
    private final ModelRenderer frame_bot2;
    private final ModelRenderer frame_bot3;
    private final ModelRenderer frame_bot4;

    public EnchantingApparatusModel() {
        super(RenderType::getEntityCutout);
        textureWidth = 32;
        textureHeight = 32;

        frame_all = new ModelRenderer(this);
        frame_all.setRotationPoint(0.0F, 1.0F, 0.0F);


        cap_top = new ModelRenderer(this);
        cap_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        frame_all.addChild(cap_top);
        cap_top.setTextureOffset(0, 0).addBox(-2.5F, -6.5F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        cap_top.setTextureOffset(0, 6).addBox(-1.5F, -5.5F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

        cap_bot = new ModelRenderer(this);
        cap_bot.setRotationPoint(0.0F, 0.0F, 0.0F);
        frame_all.addChild(cap_bot);
        setRotationAngle(cap_bot, 0.0F, 0.0F, -3.1416F);
        cap_bot.setTextureOffset(0, 0).addBox(-2.5F, -6.5F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        cap_bot.setTextureOffset(0, 6).addBox(-1.5F, -5.5F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

        frame_top = new ModelRenderer(this);
        frame_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        frame_all.addChild(frame_top);


        frame_top1 = new ModelRenderer(this);
        frame_top1.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_top.addChild(frame_top1);
        setRotationAngle(frame_top1, 0.0F, -1.5708F, 0.0F);
        frame_top1.setTextureOffset(10, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_top1.setTextureOffset(15, 0).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_top1.setTextureOffset(12, 8).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_top1.setTextureOffset(6, 13).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_top1.setTextureOffset(0, 11).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_top2 = new ModelRenderer(this);
        frame_top2.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_top.addChild(frame_top2);
        setRotationAngle(frame_top2, 0.0F, 3.1416F, 0.0F);
        frame_top2.setTextureOffset(10, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_top2.setTextureOffset(15, 0).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_top2.setTextureOffset(12, 8).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_top2.setTextureOffset(6, 13).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_top2.setTextureOffset(0, 11).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_top3 = new ModelRenderer(this);
        frame_top3.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_top.addChild(frame_top3);
        setRotationAngle(frame_top3, 0.0F, 1.5708F, 0.0F);
        frame_top3.setTextureOffset(10, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_top3.setTextureOffset(15, 0).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_top3.setTextureOffset(12, 8).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_top3.setTextureOffset(6, 13).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_top3.setTextureOffset(0, 11).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_top4 = new ModelRenderer(this);
        frame_top4.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_top.addChild(frame_top4);
        setRotationAngle(frame_top4, 0.0F, 0.0F, 0.0F);
        frame_top4.setTextureOffset(10, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_top4.setTextureOffset(15, 0).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_top4.setTextureOffset(12, 8).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_top4.setTextureOffset(6, 13).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_top4.setTextureOffset(0, 11).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_bot = new ModelRenderer(this);
        frame_bot.setRotationPoint(0.0F, 0.0F, 0.0F);
        frame_all.addChild(frame_bot);
        setRotationAngle(frame_bot, 3.1416F, 0.0F, 0.0F);


        frame_bot1 = new ModelRenderer(this);
        frame_bot1.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_bot.addChild(frame_bot1);
        setRotationAngle(frame_bot1, 0.0F, 1.5708F, 0.0F);
        frame_bot1.setTextureOffset(0, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_bot1.setTextureOffset(15, 15).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_bot1.setTextureOffset(10, 11).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_bot1.setTextureOffset(0, 0).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_bot1.setTextureOffset(9, 6).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_bot2 = new ModelRenderer(this);
        frame_bot2.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_bot.addChild(frame_bot2);
        setRotationAngle(frame_bot2, 0.0F, -3.1416F, 0.0F);
        frame_bot2.setTextureOffset(0, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_bot2.setTextureOffset(15, 15).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_bot2.setTextureOffset(10, 11).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_bot2.setTextureOffset(0, 0).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_bot2.setTextureOffset(9, 6).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_bot3 = new ModelRenderer(this);
        frame_bot3.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_bot.addChild(frame_bot3);
        setRotationAngle(frame_bot3, 0.0F, -1.5708F, 0.0F);
        frame_bot3.setTextureOffset(0, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_bot3.setTextureOffset(15, 15).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_bot3.setTextureOffset(10, 11).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_bot3.setTextureOffset(0, 0).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_bot3.setTextureOffset(9, 6).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        frame_bot4 = new ModelRenderer(this);
        frame_bot4.setRotationPoint(0.0F, -2.5F, 0.0F);
        frame_bot.addChild(frame_bot4);
        setRotationAngle(frame_bot4, 0.0F, 0.0F, 0.0F);
        frame_bot4.setTextureOffset(0, 13).addBox(-4.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        frame_bot4.setTextureOffset(15, 15).addBox(-3.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        frame_bot4.setTextureOffset(10, 11).addBox(-6.5F, 1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        frame_bot4.setTextureOffset(0, 0).addBox(-6.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        frame_bot4.setTextureOffset(9, 6).addBox(-5.5F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        frame_all.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
