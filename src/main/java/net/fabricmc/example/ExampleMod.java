package net.fabricmc.example;

import net.fabricmc.example.block.BlockRegistry;
import net.fabricmc.example.item.BookItem;
import net.fabricmc.example.item.CustomAxeItem;
import net.fabricmc.example.item.CustomHoeItem;
import net.fabricmc.example.item.CustomPickaxeItem;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.common.collect.Lists;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {

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

	public static final Item YOUR_ITEM = new BookItem(new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final Item YOUR_ITEM2 = new BookItem(new FabricItemSettings().group(ItemGroup.REDSTONE));

	public static final ToolItem POTATO_SHOVEL = new ShovelItem(PotatoToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final ToolItem POTATO_SWORD = new SwordItem(PotatoToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().group(ExampleMod.ITEM_GROUP));

	public static final ToolItem POTATO_PICKAXE = new CustomPickaxeItem(PotatoToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final ToolItem POTATO_AXE = new CustomAxeItem(PotatoToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings().group(ExampleMod.ITEM_GROUP));
	public static final ToolItem POTATO_HOE = new CustomHoeItem(PotatoToolMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings().group(ExampleMod.ITEM_GROUP));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		BlockRegistry.register();

		Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric"), YOUR_ITEM);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item2"), YOUR_ITEM2);

		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_shovel"), POTATO_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_sword"), POTATO_SWORD);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_pickaxe"), POTATO_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_axe"), POTATO_AXE);
		Registry.register(Registry.ITEM, new Identifier("tutorial", "potato_hoe"), POTATO_HOE);

		SheepShearCallback.EVENT.register((player, sheep) -> {

			sheep.setSheared(true);

			ItemStack stack = new ItemStack(Items.DIAMOND);
			BlockPos sheep_pos = sheep.getLandingPos();
			ItemEntity itemEntity = new ItemEntity(player.world, sheep_pos.getX(), sheep_pos.getY(), sheep_pos.getZ(), stack);
			player.world.spawnEntity(itemEntity);

			return ActionResult.FAIL;
		});

		createRecipe();
	}

	public static JsonObject COPPER_PICKAXE_RECIPE = null;

	public void createRecipe() {

		// if (FabricLoader.getInstance().isModLoaded("custom_mod")) {
			COPPER_PICKAXE_RECIPE = createShapedRecipeJson(
				// 这三行数组的值通过下标绑定
				// # + new Identifier("minecraft", "dirt") + item
				// | + new Identifier("obsidian") + item
				Lists.newArrayList('#','|'), //
				Lists.newArrayList(new Identifier("minecraft", "dirt"), new Identifier("obsidian")), //The items/tags we are using as input.
				Lists.newArrayList("item", "item"), //Whether the input we provided is a tag or an item.
				Lists.newArrayList(
					"###",
					" | ",
					" | "
				), //The crafting pattern.
				new Identifier("obsidian") //The crafting output
			);
		// }
	}

	public static JsonObject createShapedRecipeJson(ArrayList<Character> keys, ArrayList<Identifier> items, ArrayList<String> type, ArrayList<String> pattern, Identifier output) {
        //Creating a new json object, where we will store our recipe.
        JsonObject json = new JsonObject();
        //The "type" of the recipe we are creating. In this case, a shaped recipe.
        json.addProperty("type", "minecraft:crafting_shaped");
        //This creates:
        //"type": "minecraft:crafting_shaped"

        //We create a new Json Element, and add our crafting pattern to it.
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(pattern.get(0));
        jsonArray.add(pattern.get(1));
        jsonArray.add(pattern.get(2));
        //Then we add the pattern to our json object.
        json.add("pattern", jsonArray);
        //This creates:
        //"pattern": [
        //  "###",
        //  " | ",
        //  " | "
        //]

        //Next we need to define what the keys in the pattern are. For this we need different JsonObjects per key definition, and one main JsonObject that will contain all of the defined keys.
        JsonObject individualKey; //Individual key
        JsonObject keyList = new JsonObject(); //The main key object, containing all the keys

        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), items.get(i).toString()); //This will create a key in the form "type": "input", where type is either "item" or "tag", and input is our input item.
            keyList.add(keys.get(i) + "", individualKey); //Then we add this key to the main key object.
            //This will add:
            //"#": { "tag": "c:copper_ingots" }
            //and after that
            //"|": { "item": "minecraft:sticks" }
            //and so on.
        }

        json.add("key", keyList);
        //And so we get:
        //"key": {
        //  "#": {
        //    "tag": "c:copper_ingots"
        //  },
        //  "|": {
        //    "item": "minecraft:stick"
        //  }
        //},

        //Finally, we define our result object
        JsonObject result = new JsonObject();
        result.addProperty("item", output.toString());
        result.addProperty("count", 1);
        json.add("result", result);
        //This creates:
        //"result": {
        //  "item": "modid:copper_pickaxe",
        //  "count": 1
        //}

        return json;
    }
}
