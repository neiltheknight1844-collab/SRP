package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public final class SrpCreatures {

    public record Def(
            String id,               // registry name, e.g. "inf_human"
            float width,
            float height,
            int eggPrimary,
            int eggSecondary,
            ResourceLocation texture, // srpproto:textures/entity/...
            String sndAmbient,        // e.g. "infectedhuman.growl"
            String sndHurt,           // e.g. "infectedhuman.hurt"
            String sndDeath           // e.g. "infectedhuman.death"
    ) {}

    // Start with a small set; add more by appending entries.
    public static final List<Def> ALL = List.of(
            new Def(
                    "inf_human",
                    0.6f, 1.95f,
                    0x2b2b2b, 0x8b0000,
                    new ResourceLocation(SRPProto.MODID, "textures/entity/human_infected.png"),
                    "infectedhuman.growl",
                    "infectedhuman.hurt",
                    "infectedhuman.death"
            )
            // Add more Def(...) entries here
    );

    private SrpCreatures() {}
}
