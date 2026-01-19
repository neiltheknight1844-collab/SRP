package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SRPProto.MODID);

    public static final RegistryObject<Item> PARASITE_SPAWN_EGG =
            ITEMS.register("parasite_spawn_egg",
                    () -> new SpawnEggItem(
                            ModEntities.PARASITE.get(),
                            0x2b2b2b,
                            0x8b0000,
                            new Item.Properties()
                    ));

    private ModItems() {}

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void onBuildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(PARASITE_SPAWN_EGG.get());
        }
    }
}
