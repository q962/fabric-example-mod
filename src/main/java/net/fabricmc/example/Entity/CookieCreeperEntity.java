package net.fabricmc.example.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class CookieCreeperEntity extends CreeperEntity  {

	public CookieCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);

		System.out.println("CookieCreeperEntity");
	}

}
