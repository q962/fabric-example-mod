package net.fabricmc.example;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.example.Entity.CookieCreeperEntity;
import net.fabricmc.example.Entity.EntityRegistry;
import net.fabricmc.example.Recipe.Recipe;
import net.fabricmc.example.block.BlockRegistry;
import net.fabricmc.example.loot.LootRegistry;
import net.fabricmc.example.event.CallbackRegistry;
import net.fabricmc.example.item.ItemRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		EntityRegistry.registre();
		BlockRegistry.register();
		ItemRegistry.register();
		CallbackRegistry.register();
		Recipe.create();
		LootRegistry.register();
	}
}
