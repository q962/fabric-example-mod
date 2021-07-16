package net.fabricmc.example.Material;

import net.fabricmc.example.item.ItemRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
// import net.minecraft.item.C;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MaterialRegistry {

	public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new CustomArmorMaterial();
	// public static final Item CUSTOM_MATERIAL = new CustomMaterialItem(new Item.Settings().group(ItemRegistry.ITEM_GROUP));
	// If you made a new material, this is where you would note it.
	public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemRegistry.ITEM_GROUP));
	public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemRegistry.ITEM_GROUP));
	public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemRegistry.ITEM_GROUP));
	public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemRegistry.ITEM_GROUP));

	public static void register(){
		// Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_material"), CUSTOM_MATERIAL);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_material_helmet"), CUSTOM_MATERIAL_HELMET);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_material_chestplate"), CUSTOM_MATERIAL_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_material_leggings"), CUSTOM_MATERIAL_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "custom_material_boots"), CUSTOM_MATERIAL_BOOTS);
	}
}
