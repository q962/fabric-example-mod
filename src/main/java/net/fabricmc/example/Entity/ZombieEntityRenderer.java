package net.fabricmc.example.Entity;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ZombieEntityRenderer extends MobEntityRenderer<ZombieEntity, ZombieEntityModel<ZombieEntity>> {

    public ZombieEntityRenderer(Context context) {
        super(context, ZombieEntityModelBuilder.build(), 5);
    }

    @Override
    public Identifier getTexture(ZombieEntity entity) {
        return new Identifier("textures/entity/zombie/zombie.png");
        //return new Identifier("wiki_entity:textures/entity/cookie_creeper/creeper.png");
    }

}