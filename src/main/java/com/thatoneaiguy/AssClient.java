package com.thatoneaiguy;

import com.thatoneaiguy.client.AssConfig;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.option.KeyBinding;

public class AssClient implements ClientModInitializer {

    public static KeyBinding openHudKey;

    @Override
    public void onInitializeClient() {

        // Config
        MidnightConfig.init(Ass.MODID, AssConfig.class);

        /*// Radial Menu
        if ( FabricLoader.getInstance().isDevelopmentEnvironment() ) {
            openHudKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                    "key.ass.open",
                    InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_LEFT_ALT,
                    "category.ass.cat"
            ));

            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                var mc = MinecraftClient.getInstance();
                if (openHudKey.isPressed() && mc.currentScreen == null) {
                    mc.setScreen(new RadialScreen());
                }
            });
        }

        // Player Renderer
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof PlayerEntityRenderer playerRenderer) {
                playerRenderer.addFeature(new PartyHatFeatureRenderer<>(playerRenderer));
            }
        });*/
    }
}
