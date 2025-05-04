package com.cursee.peaceful_monsters.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.BaseSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BaseSpawner.class)
public class FabricBaseSpawnerMixin {

    @Redirect(method = "serverTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty peaceful_monsters$serverTickRedirect(ServerLevel instance) {
        return Difficulty.EASY;
    }

    @Redirect(method = "serverTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getCurrentDifficultyAt(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/DifficultyInstance;"))
    private DifficultyInstance peaceful_monsters$serverTickRedirect(ServerLevel instance, BlockPos blockPos) {
        DifficultyInstance oldInstance = instance.getCurrentDifficultyAt(blockPos);
        oldInstance.base = Difficulty.EASY;
        return oldInstance;
    }
}
