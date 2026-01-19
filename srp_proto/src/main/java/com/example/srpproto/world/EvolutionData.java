package com.example.srpproto.world;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class EvolutionData extends SavedData {
    private static final String KEY_STAGE = "Stage";
    private static final String KEY_PROGRESS = "Progress";

    private int stage = 0;
    private int progress = 0; // 0..99

    public int getStage() {
        return stage;
    }

    public int getProgress() {
        return progress;
    }

    public void addProgress(int amount) {
        if (amount <= 0) return;
        progress += amount;
        while (progress >= 100) {
            progress -= 100;
            stage += 1;
        }
        setDirty();
    }

    public void setStage(int stage) {
        this.stage = Math.max(0, stage);
        this.progress = 0;
        setDirty();
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt(KEY_STAGE, stage);
        tag.putInt(KEY_PROGRESS, progress);
        return tag;
    }

    public static EvolutionData load(CompoundTag tag) {
        EvolutionData data = new EvolutionData();
        data.stage = tag.getInt(KEY_STAGE);
        data.progress = tag.getInt(KEY_PROGRESS);
        return data;
    }

    public static EvolutionData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(EvolutionData::load, EvolutionData::new, "srpproto_evolution");
    }
}
