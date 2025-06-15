package com.cursee.peaceful_monsters.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MeleeAttackGoal.class)
public class FabricMeleeAttackGoalMixin {

    @Inject(method = "canContinueToUse", at = @At("TAIL"), cancellable = true)
    private void peaceful_monsters$canContinueToUseInject(CallbackInfoReturnable<Boolean> cir) {
        MeleeAttackGoal instance = (MeleeAttackGoal) (Object) this;
        LivingEntity livingEntity = instance.mob.getTarget();

        Level level = livingEntity.level();
        if (level == null) return;
        Difficulty difficulty = level.getDifficulty();

        if (cir.getReturnValue()){
            cir.setReturnValue(difficulty != Difficulty.PEACEFUL);
            instance.stop();
        }
    }
}
