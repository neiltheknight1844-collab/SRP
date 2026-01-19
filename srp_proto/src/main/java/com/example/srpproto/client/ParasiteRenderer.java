package com.example.srpproto.client;

import com.example.srpproto.entity.ParasiteEntity;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ParasiteRenderer extends MobRenderer<ParasiteEntity, ZombieModel<ParasiteEntity>> {

    // Use vanilla zombie texture so you don't need to add a texture asset yet.
    private static final ResourceLocation TEX =
            new ResourceLocation("minecraft", "textures/entity/zombie/zombie.png");

    public ParasiteRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new ZombieModel<>(ctx.bakeLayer(ModelLayers.ZOMBIE)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ParasiteEntity entity) {
        return TEX;
    }
}
