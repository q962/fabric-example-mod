package net.fabricmc.example.Entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DogEntityRenderer extends MobEntityRenderer<DogEntity, DogEntityModel<DogEntity>> {

    public DogEntityRenderer(EntityRendererFactory.Context context) {
        super(context, DogEntityModelBuilder.build(), 1f);
    }

    @Override
    public Identifier getTexture(DogEntity entity) {
        return new Identifier("textures/entity/spider/spider.png");
        //return new Identifier("wiki_entity:textures/entity/cookie_creeper/creeper.png");
    }
}
