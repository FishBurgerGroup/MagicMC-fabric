package com.fishburgergroup.magicmc;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SpellEntityRenderer extends MobEntityRenderer<SpellEntity, SpellEntityModel> {
    public SpellEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new SpellEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(SpellEntity entity) {
        return new Identifier("entitytesting", "textures/entity/cube/cube.png");
    }
}
