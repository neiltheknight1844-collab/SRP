package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public final class SrpCreatures {

    public record Def(
            String id,                // registry id, e.g. "inf_human"
            float width,
            float height,
            int eggPrimary,
            int eggSecondary,
            ResourceLocation texture   // srpproto:textures/entity/<id>.png
    ) {}

    // Add creatures here. This is the ONLY place you need to edit to expand roster.
    public static final List<Def> ALL = List.of(
            new Def("inf_human",    0.6f, 1.95f, 0x2b2b2b, 0x8b0000, tex("inf_human.png")),
            new Def("inf_cow",      0.9f, 1.40f, 0x2b2b2b, 0x6b3f2a, tex("inf_cow.png")),
            new Def("inf_pig",      0.9f, 0.9f,  0x2b2b2b, 0xff9aa2, tex("inf_pig.png")),
            new Def("inf_sheep",    0.9f, 1.30f, 0x2b2b2b, 0xffffff, tex("inf_sheep.png")),
            new Def("inf_villager", 0.6f, 1.95f, 0x2b2b2b, 0x4f2a1e, tex("inf_villager.png"))
    );

    private static ResourceLocation tex(String file) {
        return new ResourceLocation(SRPProto.MODID, "textures/entity/" + file);
    }

    private SrpCreatures() {}
}
