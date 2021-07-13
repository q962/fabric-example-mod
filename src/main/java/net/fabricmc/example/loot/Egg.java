package net.fabricmc.example.loot;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.LootManager;
import net.minecraft.item.EggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroup;

import java.io.Console;

import net.fabricmc.example.block.BlockRegistry;
import net.fabricmc.example.item.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class Egg {
	private static final Identifier COAL_ORE_LOOT_TABLE_ID = Blocks.COAL_ORE.getLootTableId();
	static boolean firstRun = true;

	public Egg() {

		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			if (COAL_ORE_LOOT_TABLE_ID.equals(id)) {
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
