package com.cursee.peaceful_monsters;

import com.cursee.peaceful_monsters.core.registry.RegistryForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class PeacefulMonstersForge {

    public static IEventBus EVENT_BUS = null;
    
    public PeacefulMonstersForge(FMLJavaModLoadingContext context) {
        PeacefulMonsters.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        PeacefulMonstersForge.EVENT_BUS = context.getModEventBus();
        RegistryForge.register(PeacefulMonstersForge.EVENT_BUS);
    }

    @SuppressWarnings("removal")
    public PeacefulMonstersForge() {
        this(FMLJavaModLoadingContext.get());
    }
}
