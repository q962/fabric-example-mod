package net.fabricmc.example.Entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.attribute.DefaultAttributeContainer;

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
		// Registry.register(Registry.ITEM, new Identifier("wiki_entity", "cookie_creeper_spawn_egg"), new SpawnEggItem(COOKIE_CREEPER, 0x0DA70B, 0x73420E, new Item.Settings().group(ItemGroup.MISC)));

		// Biomes.PLAINS.getEntitySpawnList(EntityCategory.MONSTER).add(new Biome.SpawnEntry(COOKIE_CREEPER, 100, 4, 4));

	}
}
