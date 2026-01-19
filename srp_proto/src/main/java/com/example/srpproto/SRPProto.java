package com.example.srpproto;

import com.example.srpproto.registry.ModBlocks;
import com.example.srpproto.registry.ModEntities;
import com.example.srpproto.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SRPProto.MODID)
public class SRPProto {
    public static final String MODID = "srpproto";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SRPProto() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITIES.register(modBus);
        ModEntities.registerAttributes(modBus);
        ModItems.registerCreativeTabs(modBus);
    }
}
