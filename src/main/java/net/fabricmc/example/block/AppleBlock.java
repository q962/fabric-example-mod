package net.fabricmc.example.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
// import net.fabricmc.fabric.api;

public class AppleBlock extends Block {
	public static final BooleanProperty HARDENED = BooleanProperty.of("hardened");

	public AppleBlock(Settings settings) {
		super(settings);
		setDefaultState(getStateManager().getDefaultState().with(HARDENED, false));

	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {

		// world.setBlockState(pos, state.with(HARDENED, true));
		// ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3495eb, MY_BLOCK);

		player.sendMessage(new LiteralText("Hello, world!"), false);

		return ActionResult.SUCCESS;
	}

	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		builder.add(HARDENED);
	}

	// @Override
	// public float getHardness(BlockView blockView, BlockPos pos) {
	// 	// boolean hardened = blockState.get(HARDENED);
	// 	// if(hardened) return 2.0f;
	// 	// else return 0.5f;
	// }
}
