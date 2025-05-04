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
public class NeoForgeMeleeAttackGoalMixin {

    @Inject(method = "canContinueToUse", at = @At("TAIL"), cancellable = true)
    private void peaceful_monsters$canContinueToUseInject(CallbackInfoReturnable<Boolean> cir) {
        MeleeAttackGoal instance = (MeleeAttackGoal) (Object) this;
        LivingEntity livingEntity = instance.mob.getTarget();

        Level level = livingEntity.level();
        if (level == null) return;
        Difficulty difficulty = level.getDifficulty();

        // can continue attack if not attacking a player, or attacking a player that is neither in spectator/creative mode nor playing on Peaceful
        cir.setReturnValue(!(livingEntity instanceof Player) || (!livingEntity.isSpectator() && !((Player)livingEntity).isCreative() && difficulty != Difficulty.PEACEFUL));
    }
}
