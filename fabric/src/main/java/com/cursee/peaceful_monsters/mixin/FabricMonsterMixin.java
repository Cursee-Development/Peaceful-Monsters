package com.cursee.peaceful_monsters.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Monster.class)
public class FabricMonsterMixin {

    @Redirect(method = "checkMonsterSpawnRules", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/ServerLevelAccessor;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty peaceful_monsters$checkMonsterSpawnRulesRedirect(ServerLevelAccessor instance) {
        return Difficulty.EASY;
    }

    @Redirect(method = "checkAnyLightMonsterSpawnRules", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private static Difficulty peaceful_monsters$checkAnyLightMonsterSpawnRulesRedirect(LevelAccessor instance) {
        return Difficulty.EASY;
    }

    @Inject(method = "shouldDespawnInPeaceful", at = @At(value = "TAIL"), cancellable = true)
    private void peaceful_monsters$shouldDespawnInPeacefulInject(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
