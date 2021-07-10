package net.fabricmc.example.mixin;

import net.fabricmc.example.Recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.Map;

import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

	@Inject(method = "apply", at = @At("HEAD"))
	public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
		if (Recipe.COPPER_PICKAXE_RECIPE != null) {
			// 这个id 的意义？目前的代码没有个这个相关的 id
			map.put(new Identifier("examplemod", "copper_pickaxe"), Recipe.COPPER_PICKAXE_RECIPE);
		}
	}

}