package net.fabricmc.example;

import net.fabricmc.example.Recipe.Recipe;
import net.fabricmc.example.block.BlockRegistry;
import net.fabricmc.example.event.CallbackRegistry;
import net.fabricmc.example.item.ItemRegistry;

import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		BlockRegistry.register();
		ItemRegistry.register();
		CallbackRegistry.register();
		Recipe.create();
	}
}
