package net.fabricmc.example.item;

import net.fabricmc.example.PotatoToolMaterial;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

	public static ItemGroup ITEM_GROUP;

	public static ItemGroup OTHER_GROUP;

	public static Item YOUR_ITEM;
	public static EntityType<BookItemEntity> BOOK_ITEM_ENTITY;

	public static Item YOUR_ITEM2;

	public static ToolItem POTATO_SHOVEL;
	public static ToolItem POTATO_SWORD;
	public static ToolItem POTATO_PICKAXE;
	public static ToolItem POTATO_AXE;
	public static ToolItem POTATO_HOE;

	static {
		ITEM_GROUP = FabricItemGroupBuilder.build(
				new Identifier("tutorial", "general"),
				() -> new ItemStack(Blocks.COBBLESTONE));

		OTHER_GROUP = FabricItemGroupBuilder.create(
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

		YOUR_ITEM = (Item)Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric"), new BookItem(new FabricItemSettings().group(ITEM_GROUP)));
		YOUR_ITEM2 = (Item)Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item2"), new BookItem(new FabricItemSettings().group(ItemGroup.REDSTONE)));

		POTATO_SHOVEL = (ToolItem)Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_shovel"), new ShovelItem(PotatoToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings().group(ITEM_GROUP)));
		POTATO_SWORD = (ToolItem)Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_sword"), new SwordItem(PotatoToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().group(ITEM_GROUP)));
		POTATO_PICKAXE = (ToolItem)Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_pickaxe"), new CustomPickaxeItem(PotatoToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings().group(ITEM_GROUP)));
		POTATO_AXE = (ToolItem)Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_axe"), new CustomAxeItem(PotatoToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings().group(ITEM_GROUP)));
		POTATO_HOE = (ToolItem)Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_hoe"), new CustomHoeItem(PotatoToolMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings().group(ITEM_GROUP)));

		/*
		 * 类似 弓箭
		 */
		//BookItemEntity.BOOK_ITEM_ENTITY = Registry.register(Registry.ENTITY_TYPE,
		//		new Identifier("tutorial", "fabric"),
		//		FabricEntityTypeBuilder.<BookItemEntity>create(SpawnGroup.MISC, BookItemEntity::new).build()
		//);
		//EntityRendererRegistry.INSTANCE.register(BookItemEntity.BOOK_ITEM_ENTITY, BookItemEntityRenderer::new);

	}

	public static void register(){
	}
}
