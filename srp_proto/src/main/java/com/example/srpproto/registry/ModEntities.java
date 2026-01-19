package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import com.example.srpproto.entity.SrpBasicMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SRPProto.MODID);

    public static final Map<String, RegistryObject<EntityType<SrpBasicMob>>> CREATURES = new HashMap<>();

    static {
        for (var def : SrpCreatures.ALL) {
            CREATURES.put(def.id(), ENTITIES.register(def.id(), () ->
                    EntityType.Builder.<SrpBasicMob>of((type, level) -> new SrpBasicMob(type, level, def), MobCategory.MONSTER)
                            .sized(def.width(), def.height())
                            .build(def.id())
            ));
        }
    }

    private ModEntities() {}

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        for (var ro : CREATURES.values()) {
            event.put(ro.get(), SrpBasicMob.createAttributes().build());
        }
    }
}
