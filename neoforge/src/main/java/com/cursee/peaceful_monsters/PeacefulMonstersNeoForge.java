package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class PeacefulMonstersNeoForge {

    public static IEventBus EVENT_BUS = null;

    public PeacefulMonstersNeoForge(IEventBus modEventBus) {
        PeacefulMonsters.init();
        PeacefulMonstersNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(PeacefulMonstersNeoForge.EVENT_BUS);
    }
}