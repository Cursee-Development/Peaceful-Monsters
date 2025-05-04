package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class PeacefulMonstersForge {

    public static IEventBus EVENT_BUS = null;
    
    public PeacefulMonstersForge(FMLJavaModLoadingContext context) {
        PeacefulMonsters.init();
        PeacefulMonstersForge.EVENT_BUS = context.getModEventBus();
        RegistryForge.register(PeacefulMonstersForge.EVENT_BUS);
    }
}