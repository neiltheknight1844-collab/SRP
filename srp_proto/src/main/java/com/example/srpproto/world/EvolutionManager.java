package com.example.srpproto.world;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public final class EvolutionManager {
    private EvolutionManager() {}

    public static int getStage(ServerLevel level) {
        return EvolutionData.get(level).getStage();
    }

    public static void addProgress(ServerLevel level, int amount) {
        EvolutionData.get(level).addProgress(amount);
    }

    public static boolean canSpread(ServerLevel level, BlockPos pos) {
        int stage = getStage(level);
        // Very simple: spreading becomes more likely as stage increases.
        // Stage 0: 5% chance, Stage 5+: 30% chance.
        int chance = Math.min(30, 5 + stage * 5);
        return level.getRandom().nextInt(100) < chance;
    }

    public static boolean canEvolve(ServerLevel level, Entity entity) {
        // Example: allow evolution once stage >= 3
        return getStage(level) >= 3;
    }
}
