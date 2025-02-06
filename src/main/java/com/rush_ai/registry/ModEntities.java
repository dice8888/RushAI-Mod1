package com.rush_ai.registry;

import com.rush_ai.RushAI;
import com.rush_ai.entity.RushEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RushAI.MOD_ID);

    public static final RegistryObject<EntityType<RushEntity>> RUSH = ENTITIES.register("rush",
            () -> EntityType.Builder.of(RushEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F)
                    .build(new ResourceLocation(RushAI.MOD_ID, "rush").toString()));

    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(RUSH.get(), RushEntity.createAttributes().build());
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
        eventBus.addListener(ModEntities::registerEntityAttributes);
    }
}
