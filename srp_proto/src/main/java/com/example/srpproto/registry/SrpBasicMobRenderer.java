package com.example.srpproto.client;

import com.example.srpproto.entity.SrpBasicMob;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SrpBasicMobRenderer extends HumanoidMobRenderer<SrpBasicMob, HumanoidModel<SrpBasicMob>> {

    public SrpBasicMobRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(SrpBasicMob entity) {
        return entity.def().texture();
    }
}
