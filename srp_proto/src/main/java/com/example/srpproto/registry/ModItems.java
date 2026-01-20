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

import java.util.LinkedHashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SRPProto.MODID);

    public static final Map<String, RegistryObject<Item>> SPAWN_EGGS = new LinkedHashMap<>();

    static {
        for (var def : SrpCreatures.ALL) {
            var id = def.id();
            var ent = ModEntities.CREATURES.get(id);

            SPAWN_EGGS.put(id, ITEMS.register(id + "_spawn_egg", () ->
                    new SpawnEggItem(
                            ent.get(),
                            def.eggPrimary(),
                            def.eggSecondary(),
                            new Item.Properties()
                    )));
        }
    }

    private ModItems() {}

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void onBuildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            for (var ro : SPAWN_EGGS.values()) {
                event.accept(ro.get());
            }
        }
    }
}
