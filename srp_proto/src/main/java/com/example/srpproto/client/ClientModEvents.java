package com.example.srpproto.client;

import com.example.srpproto.SRPProto;
import com.example.srpproto.registry.ModEntities;
import com.example.srpproto.registry.SrpCreatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        for (var def : SrpCreatures.ALL) {
            var ro = ModEntities.CREATURES.get(def.id());
            if (ro == null) continue;

            if (def.modelKind() == SrpCreatures.ModelKind.QUADRUPED) {
                event.registerEntityRenderer(ro.get(), SrpQuadrupedRenderer::new);
            } else {
                event.registerEntityRenderer(ro.get(), SrpHumanoidRenderer::new);
            }
        }
    }
}
