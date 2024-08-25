package com.thatoneaiguy;

import com.thatoneaiguy.client.AssConfig;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;

public class AssClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MidnightConfig.init(Ass.MODID, AssConfig.class);
    }
}
