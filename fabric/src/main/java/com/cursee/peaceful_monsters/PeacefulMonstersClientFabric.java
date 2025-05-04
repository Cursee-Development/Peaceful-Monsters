package com.cursee.peaceful_monsters;

import net.fabricmc.api.ClientModInitializer;

public class PeacefulMonstersClientFabric implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        PeacefulMonstersClient.init();
    }
}
