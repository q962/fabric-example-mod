package net.fabricmc.example.Material;

import net.fabricmc.example.item.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial implements  ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};

	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 40;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ItemRegistry.YOUR_ITEM);
	}

	/**
	 * assets\minecraft\textures\models\armor
	 * 注意是 minecraft 命名空间
	 * 1.17 这两个有用，不知道如何制作
	 * <getName()>_layer_1.png
	 * <getName()>_layer_2.png
	 * 这个没效果
	 * <getName()>_boots.png
	 * <getName()>_chestplate.png
	 * <getName()>_helmet.png
	 * <getName()>_leggings.png
	 */
	@Override
	public String getName() {
		return "gilded_netherite";
	}

	@Override
	public float getToughness() {
		return 3.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.1F;
	}
}