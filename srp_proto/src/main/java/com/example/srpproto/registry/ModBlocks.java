package com.example.srpproto.registry;

import com.example.srpproto.SRPProto;
import com.example.srpproto.block.InfestationBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SRPProto.MODID);

    public static final RegistryObject<Block> INFESTATION = BLOCKS.register(
            "infestation",
            () -> new InfestationBlock(BlockBehaviour.Properties.of()
                    .strength(1.5F)
                    .sound(SoundType.SLIME_BLOCK)
                    .randomTicks()
            )
    );
}
