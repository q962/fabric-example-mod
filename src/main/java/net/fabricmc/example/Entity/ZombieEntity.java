package net.fabricmc.example.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class ZombieEntity extends net.minecraft.entity.mob.ZombieEntity  {

	public ZombieEntity(EntityType<? extends net.minecraft.entity.mob.ZombieEntity> entityType, World world) {
		super(entityType, world);
		System.out.println("CookieCreeperEntity");
	}
}
