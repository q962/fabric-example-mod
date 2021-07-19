package net.fabricmc.example.mixin;

import net.fabricmc.example.Attr.DefaultAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

/**
 * 好家伙，还得使用 FabricDefaultAttributeRegistry.register()
 * 使用另一种注入方式
 */
@Mixin(DefaultAttributeRegistry.class)
public class DefaultAttributeRegistryMixin {

    @Shadow
    private static @Final
    Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer> DEFAULT_ATTRIBUTE_REGISTRY;

    @Overwrite
    public static DefaultAttributeContainer get(EntityType<? extends LivingEntity> type){

        if( DefaultAttribute.DEFAULT_ATTRIBUTE_REGISTRY_2 != null && DefaultAttribute.DEFAULT_ATTRIBUTE_REGISTRY_2.containsKey(type) ){
            return DefaultAttribute.DEFAULT_ATTRIBUTE_REGISTRY_2.get(type);
        } else {
            return DEFAULT_ATTRIBUTE_REGISTRY.get(type);
        }
    }
}
