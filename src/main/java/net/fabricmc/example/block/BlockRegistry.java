package net.fabricmc.example.block;

import java.awt.Color;

import net.fabricmc.example.item.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

	public static final Block APPLE_BLOCK_B;
	public static final Item APPLE_BLOCK_I;

	public static final Block BOX_BLOCK_B;
	public static final Item BOX_BLOCK_I;

	static {
		Block _APPLE_BLOCK = new AppleBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
		APPLE_BLOCK_B = Registry.register(Registry.BLOCK, new Identifier("tutorial", "apple_block"), _APPLE_BLOCK);
		APPLE_BLOCK_I = Registry.register(Registry.ITEM, new Identifier("tutorial", "apple_block"), new BlockItem(_APPLE_BLOCK, new FabricItemSettings().group(ItemRegistry.ITEM_GROUP)));

		Block BOX_BLOCK = new EventBoxBlock(Color.red.getRGB(), FabricBlockSettings.of(Material.STONE).hardness(1.0f));
		BOX_BLOCK_B = Registry.register(Registry.BLOCK, new Identifier("tutorial", "box_block"), BOX_BLOCK);
		BOX_BLOCK_I = Registry.register(Registry.ITEM, new Identifier("tutorial", "box_block"), new BlockItem(BOX_BLOCK, new FabricItemSettings().group(ItemRegistry.ITEM_GROUP)));
	}

	public static void register() {
	}
}
