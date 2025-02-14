package net.fabricmc.example.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BookItem extends Item {

	public BookItem(Settings settings) {
		super(settings);

	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
	}

	@Override
	public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
		return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		super.onCraft(stack, world, player);
	}

	@Override
	public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
		return super.onStackClicked(stack, slot, clickType, player);
	}
}
