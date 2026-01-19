package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import com.example.srpproto.entity.ParasiteEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SRPProto.MODID);

    public static final RegistryObject<EntityType<ParasiteEntity>> PARASITE = ENTITIES.register(
            "parasite",
            () -> EntityType.Builder.of(ParasiteEntity::new, MobCategory.MONSTER)
                    .sized(0.9F, 2.0F)
                    .clientTrackingRange(8)
                    .build("parasite")
    );

    public static void registerAttributes(IEventBus modBus) {
        modBus.addListener(ModEntities::onAttributes);
    }

    private static void onAttributes(EntityAttributeCreationEvent event) {
        AttributeSupplier supplier = ParasiteEntity.createAttributes().build();
        event.put(PARASITE.get(), supplier);
    }
}
