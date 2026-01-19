package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import com.example.srpproto.entity.ParasiteEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SRPProto.MODID);

    public static final RegistryObject<EntityType<ParasiteEntity>> PARASITE =
            ENTITIES.register("parasite",
                    () -> EntityType.Builder.of(ParasiteEntity::new, MobCategory.MONSTER)
                            .sized(0.9F, 2.0F)
                            .build("parasite"));

    private ModEntities() {}

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PARASITE.get(), ParasiteEntity.createAttributes().build());
    }
}
