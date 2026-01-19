package com.example.srpproto.entity;

import com.example.srpproto.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ParasiteEntity extends Monster {

    public ParasiteEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    /** Attributes for registration in EntityAttributeCreationEvent */
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    /* -----------------------------
     * Sounds (Human Infected)
     * ----------------------------- */

    @Override
    protected SoundEvent getAmbientSound() {
        // Human Infected growls (your registered sound event)
        return ModSounds.INFECTEDHUMAN_GROWL.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.INFECTEDHUMAN_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.INFECTEDHUMAN_DEATH.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        // If you later add a custom step sound, swap this out.
        this.playSound(SoundEvents.SILVERFISH_STEP, 0.15F, 1.0F);
    }

    @Override
    public int getAmbientSoundInterval() {
        // How often the ambient growl triggers (in ticks). 80 = ~4 seconds.
        return 80;
    }
}
