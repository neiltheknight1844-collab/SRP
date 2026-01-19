package com.example.srpproto.events;

import com.example.srpproto.SRPProto;
import com.example.srpproto.world.EvolutionData;
import com.example.srpproto.world.EvolutionManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SRPProto.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    private static int serverTicks = 0;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        serverTicks++;
        if (serverTicks % 1200 != 0) return; // ~60s at 20 TPS

        // Advance evolution slowly over time in every loaded overworld.
        // (For a prototype this is fine; later we can make it per-dimension or per-chunk.)
        event.getServer().getAllLevels().forEach(level -> {
            if (level instanceof ServerLevel serverLevel) {
                EvolutionManager.addProgress(serverLevel, 2);
            }
        });
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        register(event.getDispatcher());
    }

    private static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("srp_stage")
                        .requires(src -> src.hasPermission(2))
                        .then(Commands.literal("get").executes(ctx -> {
                            ServerLevel level = ctx.getSource().getLevel();
                            int stage = EvolutionManager.getStage(level);
                            int prog = EvolutionData.get(level).getProgress();
                            ctx.getSource().sendSuccess(() -> Component.literal("SRP stage=" + stage + " progress=" + prog + "/100"), false);
                            return stage;
                        }))
                        .then(Commands.literal("set")
                                .then(Commands.argument("stage", IntegerArgumentType.integer(0, 999))
                                        .executes(ctx -> {
                                            int stage = IntegerArgumentType.getInteger(ctx, "stage");
                                            ServerLevel level = ctx.getSource().getLevel();
                                            EvolutionData.get(level).setStage(stage);
                                            ctx.getSource().sendSuccess(() -> Component.literal("Set SRP stage to " + stage), true);
                                            return 1;
                                        })))
                        .then(Commands.literal("add")
                                .then(Commands.argument("progress", IntegerArgumentType.integer(1, 10000))
                                        .executes(ctx -> {
                                            int amount = IntegerArgumentType.getInteger(ctx, "progress");
                                            ServerLevel level = ctx.getSource().getLevel();
                                            EvolutionManager.addProgress(level, amount);
                                            ctx.getSource().sendSuccess(() -> Component.literal("Added " + amount + " progress"), true);
                                            return 1;
                                        })))
        );
    }
}
