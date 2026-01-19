package com.example.srpproto.client;

import com.example.srpproto.entity.ParasiteEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ParasiteRenderer extends HumanoidMobRenderer<ParasiteEntity, HumanoidModel<ParasiteEntity>> {

    // Vanilla zombie texture so you don't need assets yet.
    private static final ResourceLocation TEX =
            new ResourceLocation("minecraft", "textures/entity/zombie/zombie.png");

    public ParasiteRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ParasiteEntity entity) {
        return TEX;
    }
}
