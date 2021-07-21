package net.fabricmc.example.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.World;

public class BookItemEntity extends ItemEntity {
    public static EntityType<BookItemEntity> BOOK_ITEM_ENTITY;

    public BookItemEntity(World world) {
        super(BOOK_ITEM_ENTITY, world);
    }

    public BookItemEntity(EntityType<BookItemEntity> bookItemEntityEntityType, World world) {
        super(BOOK_ITEM_ENTITY, world);
    }

    @Override
    public boolean isAttackable() {
        return false;
    }
}
