package com.thatoneaiguy.client.render.entity;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

import java.util.Calendar;
import java.util.Date;

public class PartyHatFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {

    private static final Identifier PARTY_HAT_TEXTURE = new Identifier("ass", "textures/entity/maroon.png");

    public PartyHatFeatureRenderer(FeatureRendererContext<T, M> context) {
        super(context);
    }

    /*@Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (entity instanceof AbstractClientPlayerEntity playerEntity) {
            // Check if it's the player's birthday
            if (isPlayerBirthday()) {
                matrices.push();
                // Cast to the player model
                if (this.getContextModel() instanceof PlayerEntityModel) {
                    PlayerEntityModel<T> playerModel = (PlayerEntityModel<T>) this.getContextModel();
                    // Position and scale the hat on the player's head
                    playerModel.head.rotate(matrices);
                    matrices.translate(0.0, -0.75, 0.0);
                    matrices.scale(0.6f, 0.6f, 0.6f);
                    matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F));

                    // Bind the hat texture
                    VertexConsumerProvider.Immediate immediate = (VertexConsumerProvider.Immediate) vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(PARTY_HAT_TEXTURE));
                    playerModel.render(matrices, immediate.getBuffer(RenderLayer.getEntityTranslucent(PARTY_HAT_TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                }
                matrices.pop();
            }
        }
    }*/

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (entity instanceof AbstractClientPlayerEntity playerEntity) {
            // Check if it's the player's birthday
            if (isPlayerBirthday()) {
                matrices.push();

                // Check if the context model is an instance of PlayerEntityModel
                if (this.getContextModel() instanceof PlayerEntityModel<?>) {
                    PlayerEntityModel<T> playerModel = (PlayerEntityModel<T>) this.getContextModel();

                    // Rotate and position the model's head for the hat
                    playerModel.head.rotate(matrices);
                    matrices.translate(0.0, -2, 0.0);
                    matrices.scale(2f, 2, 2f);
                    matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F));

                    // Render the party hat
                    VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(PARTY_HAT_TEXTURE));
                    playerModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                }

                matrices.pop();
            }
        }
    }

    private static boolean isPlayerBirthday() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        // calendar.get(2) + 1 == { MONTH # } && calendar.get(5) == { DAY # }

        if ( calendar.get(2) + 1 == 3 && calendar.get(5) == 14 ) { return true; } // Spirit
        else if ( calendar.get(2) + 1 == 5 && calendar.get(5) == 26 ) { return true; } // Nopeable
        else if ( calendar.get(2) + 1 == 8 && calendar.get(5) == 28 ) { return true; } // Test
        
        return false;
    }
}