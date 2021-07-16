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
	private BlockPos block_pos;

	public DogBlockEntity(BlockPos pos, BlockState state) {
		super(BLOCK_ENTITY, pos, state);
		if( pos != null ){
			this.block_pos = new BlockPos(pos);
		}
	}

	@Override
	public NbtCompound writeNbt(NbtCompound tag) {
		super.writeNbt(tag);

		// Save the current value of the number to the tag
		tag.putInt("number", number);
		if( block_pos != null ){
			tag.putLong("block_pos", block_pos.asLong());
		}

		return tag;
	}

	@Override
	public void readNbt(NbtCompound tag) {
		super.readNbt(tag);
		number = tag.getInt("number");
		block_pos = BlockPos.fromLong(tag.getLong("block_pos"));
	}

	public void hello (){
		if( block_pos != null ){
			System.out.println(block_pos.toShortString());
		} else {
			System.out.println("pos is null");
		}
	}

	public static void tick(World world, BlockPos pos, BlockState state, BlockEntity be) {
		// System.out.println("tick:"+be);
	}
}
