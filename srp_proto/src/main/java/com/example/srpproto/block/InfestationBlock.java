package com.example.srpproto.block;

import com.example.srpproto.registry.ModBlocks;
import com.example.srpproto.world.EvolutionManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class InfestationBlock extends Block {
    public InfestationBlock(Properties properties) {
        super(properties.mapColor(MapColor.COLOR_GREEN));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!EvolutionManager.canSpread(level, pos)) {
            return;
        }

        Direction dir = Direction.getRandom(random);
        BlockPos target = pos.relative(dir);
        BlockState targetState = level.getBlockState(target);

        // Simple spread rule: infect nearby stone/dirt or fill nearby air.
        if (targetState.isAir() || targetState.is(net.minecraft.world.level.block.Blocks.STONE) || targetState.is(net.minecraft.world.level.block.Blocks.DIRT)) {
            level.setBlock(target, ModBlocks.INFESTATION.get().defaultBlockState(), 3);
            EvolutionManager.addProgress(level, 1); // spreading pushes evolution forward
        }
    }
}
