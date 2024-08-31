package com.thatoneaiguy;

import com.thatoneaiguy.client.AssConfig;
import com.thatoneaiguy.client.render.entity.GuildedPlayerEntityRenderer;
import com.thatoneaiguy.client.render.entity.PartyHatFeatureRenderer;
import com.thatoneaiguy.client.screen.RadialScreen;
import com.thatoneaiguy.init.AssEntityTypes;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AssClient implements ClientModInitializer {

    public static KeyBinding openHudKey;

    @Override
    public void onInitializeClient() {

        // Config
        MidnightConfig.init(Ass.MODID, AssConfig.class);

        // Radial Menu
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
        });
    }
}
