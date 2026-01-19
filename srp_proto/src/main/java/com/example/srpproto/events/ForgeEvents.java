package com.example.srpproto.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ForgeEvents {

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) event.level;

            // Placeholder for evolution / world logic
            if (!serverLevel.isClientSide) {
                // future logic here
            }
        }
    }
}
