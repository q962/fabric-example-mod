package net.fabricmc.example.Entity;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CookieCreeperEntityRenderer extends MobEntityRenderer<CookieCreeperEntity, CookieCreeperEntityModel<CookieCreeperEntity>> {

	public CookieCreeperEntityRenderer(Context context) {
		super(context, CookieCreeperEntityModelBuilder.build(), 1);
	}

	@Override
	public Identifier getTexture(CookieCreeperEntity entity) {
		return new Identifier("textures/entity/creeper/creeper.png");
		//return new Identifier("wiki_entity:textures/entity/cookie_creeper/creeper.png");
	}

}