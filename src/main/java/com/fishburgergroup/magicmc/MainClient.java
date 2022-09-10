package com.fishburgergroup.magicmc;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        /*
         * 方块实体渲染器的注册，提供模型、阴影大小和贴图的渲染器。
         *
         * 实体渲染器也可以在实体基于上下文进行渲染前(EndermanEntityRenderer#render). 操作模型。
         */
        EntityRendererRegistry.INSTANCE.register(Main.SPELL, (dispatcher, context) -> {
            return new SpellEntityRenderer(dispatcher);
        });
    }
}
