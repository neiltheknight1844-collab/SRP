ppackage com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SRPProto.MODID);

    public static final RegistryObject<Item> PARASITE_SPAWN_EGG =
            ITEMS.register("parasite_spawn_egg",
                    () -> new SpawnEggItem(
                            ModEntities.PARASITE,
                            0x4b4b4b,
                            0x8a0000,
                            new Item.Properties()
                    ));

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
        MinecraftForge.EVENT_BUS.addListener(ModItems::addCreative);
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(PARASITE_SPAWN_EGG.get());
        }
    }
}

