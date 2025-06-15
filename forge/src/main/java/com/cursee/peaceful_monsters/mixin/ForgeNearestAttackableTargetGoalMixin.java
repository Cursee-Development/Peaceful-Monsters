package com.cursee.peaceful_monsters.mixin;

import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NearestAttackableTargetGoal.class)
public class ForgeNearestAttackableTargetGoalMixin {

    @Shadow
    protected LivingEntity target;

    @Inject(method = "canUse", at = @At("TAIL"), cancellable = true)
    private void peaceful_monsters$canUseInjection(CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) cir.setReturnValue(target.level().getDifficulty() != Difficulty.PEACEFUL);
    }
}
