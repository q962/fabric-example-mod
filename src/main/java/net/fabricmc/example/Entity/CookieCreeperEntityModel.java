package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CreeperEntityModel;

public class CookieCreeperEntityModel<T extends CookieCreeperEntity> extends CreeperEntityModel<CookieCreeperEntity> {

    public CookieCreeperEntityModel(ModelPart root) {
        super(root);
    }
}
