package net.fabricmc.example.item;

import net.fabricmc.example.PotatoToolMaterial;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("tutorial", "general"),
		() -> new ItemStack(Blocks.COBBLESTONE));

	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
		new Identifier("tutorial", "other"))
		.icon(() -> new ItemStack(Items.BOWL))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(Blocks.BONE_BLOCK));
			stacks.add(new ItemStack(Items.APPLE));
			// stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
			stacks.add(ItemStack.EMPTY);
			stacks.add(new ItemStack(Items.IRON_SHOVEL));
		})
		.build();

	public static final Item YOUR_ITEM = new BookItem(new FabricItemSettings().group(ITEM_GROUP));
	public static final Item YOUR_ITEM2 = new BookItem(new FabricItemSettings().group(ItemGroup.REDSTONE));

	public static final ToolItem POTATO_SHOVEL = new ShovelItem(PotatoToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings().group(ITEM_GROUP));
	public static final ToolItem POTATO_SWORD = new SwordItem(PotatoToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().group(ITEM_GROUP));

	public static final ToolItem POTATO_PICKAXE = new CustomPickaxeItem(PotatoToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings().group(ITEM_GROUP));
	public static final ToolItem POTATO_AXE = new CustomAxeItem(PotatoToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings().group(ITEM_GROUP));
	public static final ToolItem POTATO_HOE = new CustomHoeItem(PotatoToolMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings().group(ITEM_GROUP));

	public static void register(){

		Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric"), YOUR_ITEM);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item2"), YOUR_ITEM2);

		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_shovel"), POTATO_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_sword"), POTATO_SWORD);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_pickaxe"), POTATO_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_axe"), POTATO_AXE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_hoe"), POTATO_HOE);
	}
}
