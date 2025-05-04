package com.cursee.peaceful_monsters;

import net.minecraft.resources.ResourceLocation;

public class PeacefulMonsters {

    public static void init() {}

    public static ResourceLocation identifier(String value) {
        return new ResourceLocation(Constants.MOD_ID, value);
    }
}