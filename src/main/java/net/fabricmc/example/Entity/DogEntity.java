package net.fabricmc.example.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

public class DogEntity extends SpiderEntity {

    public DogEntity(EntityType<? extends DogEntity> entityType, World world) {
        super(entityType, world);

        System.out.println("DogEntity");
    }
}
