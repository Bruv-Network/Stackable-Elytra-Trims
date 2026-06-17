package com.golem.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import com.golem.stackableelytratrims.StackableElytraTrimsClient;

public final class StackableElytraTrimsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        StackableElytraTrimsClient.initClient();
    }
}
