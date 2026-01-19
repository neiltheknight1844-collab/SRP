package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public final class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SRPProto.MODID);

    private static final Map<String, RegistryObject<SoundEvent>> BY_KEY = new HashMap<>();

    public static RegistryObject<SoundEvent> registerKey(String key) {
        return BY_KEY.computeIfAbsent(key, k ->
                SOUNDS.register(k, () ->
                        SoundEvent.createVariableRangeEvent(new ResourceLocation(SRPProto.MODID, k)))
        );
    }

    public static RegistryObject<SoundEvent> getKey(String key) {
        return BY_KEY.get(key);
    }

    private ModSounds() {}

    public static void register(IEventBus bus) {
        // pre-register all creature sound keys so nothing is missing at runtime
        for (var def : SrpCreatures.ALL) {
            registerKey(def.sndAmbient());
            registerKey(def.sndHurt());
            registerKey(def.sndDeath());
        }
        SOUNDS.register(bus);
    }
}
