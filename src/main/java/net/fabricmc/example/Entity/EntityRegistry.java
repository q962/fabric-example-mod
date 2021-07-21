package net.fabricmc.example.Entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
	public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER;
	public static final EntityType<ZombieEntity> ZOMBIE_ENTITY;
	public static final EntityType<DogEntity> DOG_ENTITY;

	static {

		COOKIE_CREEPER = Registry.register(Registry.ENTITY_TYPE,
				new Identifier("tutorial", "cookie_creeper"),
				FabricEntityTypeBuilder.create(
						SpawnGroup.CREATURE, CookieCreeperEntity::new
				).dimensions(EntityDimensions.fixed(1, 2)).build());

		EntityRendererRegistry.INSTANCE.register(COOKIE_CREEPER, CookieCreeperEntityRenderer::new);
		/* 注意调用方法
		 * createHostileAttributes
		 */
		FabricDefaultAttributeRegistry.register(COOKIE_CREEPER, CreeperEntity.createHostileAttributes());


		ZOMBIE_ENTITY = Registry.register(Registry.ENTITY_TYPE,
				new Identifier("tutorial", "zombie"),
				FabricEntityTypeBuilder.create(
						SpawnGroup.CREATURE, ZombieEntity::new
				).dimensions(EntityDimensions.fixed(1, 2)).build());

		EntityRendererRegistry.INSTANCE.register(ZOMBIE_ENTITY, ZombieEntityRenderer::new);
		/* 注意调用方法
		 * createZombieAttributes
		 */
		FabricDefaultAttributeRegistry.register(ZOMBIE_ENTITY, ZombieEntity.createZombieAttributes());

		DOG_ENTITY = Registry.register(Registry.ENTITY_TYPE,
				new Identifier("tutorial", "dog"),
				FabricEntityTypeBuilder.create(
						SpawnGroup.CREATURE, DogEntity::new
				).dimensions(EntityDimensions.fixed(1, 2)).build());

		EntityRendererRegistry.INSTANCE.register(DOG_ENTITY, DogEntityRenderer::new);
		/* 注意调用方法
		 * createSpiderAttributes
		 */
		FabricDefaultAttributeRegistry.register(DOG_ENTITY, DogEntity.createSpiderAttributes());
	}

	public static void register(){

	}
}
