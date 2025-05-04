package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryNeoForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class PeacefulMonstersNeoForge {

    public static IEventBus EVENT_BUS = null;

    public PeacefulMonstersNeoForge(IEventBus modEventBus) {
        PeacefulMonsters.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        PeacefulMonstersNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(PeacefulMonstersNeoForge.EVENT_BUS);
    }
}