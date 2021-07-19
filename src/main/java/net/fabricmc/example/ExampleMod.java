package net.fabricmc.example;

import net.fabricmc.example.BlockEntity.BlockEntityRegistry;
import net.fabricmc.example.Entity.EntityRegistry;
import net.fabricmc.example.Material.MaterialRegistry;
import net.fabricmc.example.Recipe.Recipe;
import net.fabricmc.example.block.BlockRegistry;
import net.fabricmc.example.Command.CommandRegistry;
import net.fabricmc.example.loot.LootRegistry;
import net.fabricmc.example.event.CallbackRegistry;
import net.fabricmc.example.item.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		EntityRegistry.register();
		BlockRegistry.register();
		ItemRegistry.register();
		CallbackRegistry.register();
		Recipe.create();
		LootRegistry.register();
		BlockEntityRegistry.register();
		MaterialRegistry.register();
		CommandRegistry.register();
	}
}
