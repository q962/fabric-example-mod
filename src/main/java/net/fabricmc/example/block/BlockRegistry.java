package net.fabricmc.example.block;

import net.fabricmc.example.item.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

	public static final Block APPLE_BLOCK = new AppleBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));

	public static void register() {
		Registry.register(Registry.BLOCK, new Identifier("tutorial", "apple_block"), APPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "apple_block"), new BlockItem(APPLE_BLOCK, new FabricItemSettings().group(ItemRegistry.ITEM_GROUP)));
	}
}
