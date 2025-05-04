package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryFabric;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class PeacefulMonstersFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        PeacefulMonsters.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        RegistryFabric.register();
    }
}
