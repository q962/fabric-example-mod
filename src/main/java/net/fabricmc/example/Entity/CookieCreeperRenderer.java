package net.fabricmc.example.Entity;

import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

public class CookieCreeperRenderer extends MobEntityRenderer<CookieCreeperEntity, CreeperEntityModel<CookieCreeperEntity>> {

	public CookieCreeperRenderer(Context context, CreeperEntityModel<CookieCreeperEntity> entityModel, float f) {
		super(context, entityModel, f);
		// super(context, new CreeperEntityModel<CookieCreeperEntity>(null), 1);
	}

	@Override
	public Identifier getTexture(CookieCreeperEntity entity) {
		return new Identifier("wiki_entity:textures/entity/cookie_creeper/creeper.png");
	}

}