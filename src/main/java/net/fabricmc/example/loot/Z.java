package net.fabricmc.example.loot;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.util.Identifier;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.item.Items;

import net.fabricmc.example.block.BlockRegistry;

public class Z {
	public Z() {
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			// 不知道从哪获取实体id，
			// 有 Blocks获取item id，却不知道 entoty id
			if (id.equals(new Identifier("minecraft:entities/zombie"))) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
					// 除了矿物，另外还会生成以下 5 个item(随机的)
					.rolls(ConstantLootNumberProvider.create(5f))
					// 必须是注册过的 item / block (register 函数返回值)
					.with(ItemEntry.builder(Items.EGG))
					.with(ItemEntry.builder(BlockRegistry.APPLE_BLOCK_I))
					.with(ItemEntry.builder(Items.CLOCK))
					;

				table.pool(poolBuilder);
			}
		});
	}
}
