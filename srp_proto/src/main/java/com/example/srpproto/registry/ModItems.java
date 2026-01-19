package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SRPProto.MODID);

    public static final RegistryObject<Item> INFESTATION_ITEM = ITEMS.register(
            "infestation",
            () -> new BlockItem(ModBlocks.INFESTATION.get(), new Item.Properties())
    );

    public static final RegistryObject<Item> PARASITE_SPAWN_EGG = ITEMS.register(
            "parasite_spawn_egg",
            () -> new SpawnEggItem(ModEntities.PARASITE.get(), 0x2b2b2b, 0x7fff7f, new Item.Properties())
    );

    public static void registerCreativeTabs(IEventBus modBus) {
        modBus.register(ModCreativeTabEvents.class);
    }

    @Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModCreativeTabEvents {
        @SubscribeEvent
        public static void buildContents(CreativeModeTabEvent.BuildContents event) {
            if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
                event.accept(PARASITE_SPAWN_EGG);
            }
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                event.accept(INFESTATION_ITEM);
            }
        }
    }
}
