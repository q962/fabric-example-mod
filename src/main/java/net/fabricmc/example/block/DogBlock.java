package net.fabricmc.example.block;

import org.apache.commons.lang3.ObjectUtils.Null;

import net.fabricmc.example.BlockEntity.DogBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DogBlock extends Block implements BlockEntityProvider  {

	public DogBlock(Settings settings) {
		super(settings);
	}

	/**
	 * 只要是block 绑定了实体
	 * 如果没有创建实体就会创建实体
	 * 例如注释实体现在世界中创建block
	 * 之后解除注释，右键还是会调用改函数创建实体
	 */
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new DogBlockEntity(pos, state);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);

		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof DogBlockEntity) {
			((DogBlockEntity) blockEntity).hello();
		}
	}

	// 周期性执行所有Ticker
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		// return DogBlockEntity::tick;
		return null;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {

		System.out.println("Dog Block use");

		// 通过这种方式获得实体
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof DogBlockEntity) {
			((DogBlockEntity) blockEntity).hello();
		}

		return ActionResult.SUCCESS;
	}
}
