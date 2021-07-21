package net.fabricmc.example.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

//public class ZombieEntity extends HostileEntity, net.minecraft.entity.mob.ZombieEntity {
public class ZombieEntity extends net.minecraft.entity.mob.ZombieEntity {

	public ZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
		System.out.println("ZombieEntity");
	}

	//public ZombieEntity(World world) {
	//	this(EntityRegistry.ZOMBIE_ENTITY, world);
	//}

}
