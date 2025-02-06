package com.rush_ai.client;

import com.rush_ai.entity.RushEntity;
import com.rush_ai.registry.ModEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModEntityRenderers {

    public static void register(IEventBus eventBus) {
        eventBus.addListener(ModEntityRenderers::registerRenderers);
    }

    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RUSH.get(), RushEntityRenderer::new);
    }
}
