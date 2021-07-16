package net.fabricmc.example.Entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
	public static final EntityType<CookieCreeperEntity> COOKIE_CREEPER;
	public static final EntityType<ZombieEntity> ZOMBIEENTITY;

	static {
		COOKIE_CREEPER = Registry.register(Registry.ENTITY_TYPE,new Identifier("tutorial", "cookie_creeper"),FabricEntityTypeBuilder.<CookieCreeperEntity>create(SpawnGroup.CREATURE, CookieCreeperEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build());

		ZOMBIEENTITY = Registry.register(Registry.ENTITY_TYPE,
			new Identifier("tutorial", "zombie"),
			FabricEntityTypeBuilder.<ZombieEntity>create(SpawnGroup.CREATURE,ZombieEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build());
	}

	public static void registre(){
	}
}
