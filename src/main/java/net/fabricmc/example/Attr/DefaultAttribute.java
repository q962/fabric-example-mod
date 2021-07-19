package net.fabricmc.example.Attr;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;

import java.util.HashMap;
import java.util.Map;

public class DefaultAttribute {
    public static Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer> DEFAULT_ATTRIBUTE_REGISTRY_2 = new HashMap<>();

    public static void register(EntityType<? extends LivingEntity> entityType, DefaultAttributeContainer.Builder builder){
        DEFAULT_ATTRIBUTE_REGISTRY_2.put(entityType, builder.build());
    }
}
