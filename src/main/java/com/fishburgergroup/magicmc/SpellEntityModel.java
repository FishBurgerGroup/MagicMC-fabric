package com.fishburgergroup.magicmc;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SpellEntityModel extends EntityModel<SpellEntity> {

    private final ModelPart base;

    public SpellEntityModel() {
        this.textureHeight = 16;
        this.textureWidth = 16;
        base = new ModelPart(this, 0, 0);
    }
    @Override
    public void setAngles(SpellEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        // 把模型变小
        matrices.translate(0, 1.125, 0);

        // 渲染方块实体
        base.render(matrices, vertices, light, overlay);
    }

}
