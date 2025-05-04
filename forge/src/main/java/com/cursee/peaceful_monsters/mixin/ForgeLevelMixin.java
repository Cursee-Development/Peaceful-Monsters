package com.cursee.peaceful_monsters.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Level.class)
public class ForgeLevelMixin {

//    @Redirect(method = "setSpawnSettings", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/ChunkSource;setSpawnSettings(ZZ)V"))
//    private void peaceful_monsters$setSpawnSettingsInject(ChunkSource instance, boolean pHostile, boolean pPeaceful) {
//        // instance.setSpawnSettings(pHostile, false);
//        Level level = (Level) (Object) this;
//        level.getChunkSource().setSpawnSettings(true, true);
//    }

    @Redirect(method = "setSpawnSettings", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/ChunkSource;setSpawnSettings(Z)V"))
    private void peaceful_monsters$setSpawnSettingsInject(ChunkSource instance, boolean pHostile) {
        // instance.setSpawnSettings(pHostile, false);
        Level level = (Level) (Object) this;
        level.getChunkSource().setSpawnSettings(true);
    }
}
