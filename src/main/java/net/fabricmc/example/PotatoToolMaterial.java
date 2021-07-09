package net.fabricmc.example;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PotatoToolMaterial implements ToolMaterial {
	public static final PotatoToolMaterial INSTANCE = new PotatoToolMaterial();

	@Override
	public int getDurability() {

		return 300;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 5.0f;
	}

	@Override
	public float getAttackDamage() {
		return 3.5f;
	}

	@Override
	public int getMiningLevel() {
		return 2;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.POTATO);
	}

}
