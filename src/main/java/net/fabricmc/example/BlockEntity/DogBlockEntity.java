package net.fabricmc.example.BlockEntity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DogBlockEntity extends BlockEntity {
	// DogBlockEntity Instance = new DogBlockEntity();
	public static BlockEntityType<DogBlockEntity> BLOCK_ENTITY;

	private int number = 7;

	public DogBlockEntity(BlockPos pos, BlockState state) {
		super(BLOCK_ENTITY, pos, state);
	}

	@Override
	public NbtCompound writeNbt(NbtCompound tag) {
		super.writeNbt(tag);

		// Save the current value of the number to the tag
		tag.putInt("number", number);

		return tag;
	}

	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);
		number = tag.getInt("number");
	}

	public static void tick(World world, BlockPos pos, BlockState state, BlockEntity be) {
		System.out.println("tick:"+be);
	}
}
