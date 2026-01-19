package com.example.srpproto;

import com.example.srpproto.registry.ModEntities;
import com.example.srpproto.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SRPProto.MODID)
public class SRPProto {

    public static final String MODID = "srpproto";

    public SRPProto() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.register(modBus);
        ModItems.register(modBus);
    }
}
