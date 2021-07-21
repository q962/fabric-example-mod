package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.SpiderEntityModel;

public class DogEntityModel<T extends DogEntity> extends SpiderEntityModel<DogEntity> {
    public DogEntityModel(ModelPart root) {
        super(root);
    }
}
