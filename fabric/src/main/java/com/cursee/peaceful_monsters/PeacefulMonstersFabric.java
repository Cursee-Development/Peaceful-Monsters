package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryFabric;
import net.fabricmc.api.ModInitializer;

public class PeacefulMonstersFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        PeacefulMonsters.init();
        RegistryFabric.register();
    }
}
