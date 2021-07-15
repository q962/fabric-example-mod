package net.fabricmc.example.BlockEntity;

import net.fabricmc.example.block.DogBlock;
import net.fabricmc.example.item.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {

	public static void register() {
		Block _BLOCK = new DogBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
		// 注册后可以使用 tick 事件函数
		DogBlockEntity.BLOCK_ENTITY =
			Registry.register(
				Registry.BLOCK_ENTITY_TYPE,
				"tutorial:dog_block_entity",
				FabricBlockEntityTypeBuilder.create(
					DogBlockEntity::new,
					_BLOCK
				).build(null)
			);

		Registry.register(Registry.BLOCK, new Identifier("tutorial", "dog_block"), _BLOCK);
		Registry.register(
			Registry.ITEM,
			new Identifier("tutorial", "dog_block"),
			new BlockItem(_BLOCK, new FabricItemSettings().group(ItemRegistry.ITEM_GROUP))
		);
	}
}
