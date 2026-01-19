package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SRPProto.MODID);

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_DEATH =
            SOUNDS.register("infectedhuman.death",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SRPProto.MODID, "infectedhuman.death")));

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_GROWL =
            SOUNDS.register("infectedhuman.growl",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SRPProto.MODID, "infectedhuman.growl")));

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_HURT =
            SOUNDS.register("infectedhuman.hurt",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SRPProto.MODID, "infectedhuman.hurt")));

    private ModSounds() {}

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
