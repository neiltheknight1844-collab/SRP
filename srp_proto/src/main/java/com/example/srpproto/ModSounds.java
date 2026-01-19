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

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_GROWL =
            register("infectedhuman.growl");

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_HURT =
            register("infectedhuman.hurt");

    public static final RegistryObject<SoundEvent> INFECTEDHUMAN_DEATH =
            register("infectedhuman.death");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name,
                () -> SoundEvent.createVariableRangeEvent(
                        new ResourceLocation(SRPProto.MODID, name)));
    }

    private ModSounds() {}

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
