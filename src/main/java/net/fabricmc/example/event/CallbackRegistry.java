package net.fabricmc.example.event;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class CallbackRegistry {

	public static void register(){

		SheepShearCallback.EVENT.register((player, sheep) -> {

			sheep.setSheared(true);

			ItemStack stack = new ItemStack(Items.DIAMOND);
			BlockPos sheep_pos = sheep.getLandingPos();
			ItemEntity itemEntity = new ItemEntity(player.world, sheep_pos.getX(), sheep_pos.getY(), sheep_pos.getZ(), stack);
			player.world.spawnEntity(itemEntity);

			return ActionResult.FAIL;
		});

	}
}
