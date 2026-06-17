package com.golem.neoforge;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.bus.api.IEventBus;

import com.golem.stackableelytratrims.StackableElytraTrims;
import com.golem.stackableelytratrims.StackableElytraTrimsClient;

@Mod(StackableElytraTrims.MOD_ID)
public final class StackableElytraTrimsNeoForge {
    public StackableElytraTrimsNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        StackableElytraTrims.init();
        
        modEventBus.addListener(this::onClientSetup);
    }
    
    private void onClientSetup(FMLClientSetupEvent event) {
        StackableElytraTrimsClient.initClient();
    }
}
