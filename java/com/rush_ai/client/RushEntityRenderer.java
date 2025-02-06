package com.rush_ai.client;

import com.rush_ai.entity.RushEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RushEntityRenderer extends HumanoidMobRenderer<RushEntity, HumanoidModel<RushEntity>> {

    private static final ResourceLocation RUSH_TEXTURE = new ResourceLocation("rush_ai", "textures/entity/rush.png");

    public RushEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(RushEntity entity) {
        return RUSH_TEXTURE;
    }
}
