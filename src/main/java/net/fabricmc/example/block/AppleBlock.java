package net.fabricmc.example.block;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.state.StateManager;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;


public class AppleBlock extends Block {
	public static final BooleanProperty HARDENED = BooleanProperty.of("hardened");
	protected final StateManager<Block, BlockState> _stateManager;

	public AppleBlock(Settings settings) {
		super(settings);
		// 幸亏有源码，不然还不知道怎么搞！！！
		StateManager.Builder<Block, BlockState> builder = new StateManager.Builder<Block, BlockState>(this);
		this.appendProperties(builder);
		this._stateManager = builder.build(Block::getDefaultState, AppleBlockState::new);
		this.setDefaultState((BlockState)this._stateManager.getDefaultState().with(HARDENED, false));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {

		// 这是方块的属性
		world.setBlockState(pos, state.with(HARDENED, true));

		if(world.isClient() ) {
			player.sendMessage(new LiteralText("Client: Hello, world!"), false);
		}else {
			player.sendMessage(new LiteralText("Server: Hello, world!"), false);
		}

		return ActionResult.SUCCESS;
	}

	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		builder.add(HARDENED);
	}

	@Override
	public StateManager<Block, BlockState> getStateManager() {
		return this._stateManager;
	}
}

class AppleBlockState extends BlockState {

	public AppleBlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> immutableMap,
			MapCodec<BlockState> mapCodec) {
		super(block, immutableMap, mapCodec);
	}

	/**
	 * 获取是通过属性判断，是不是特殊的方块
	 */
	@Override
	public float getHardness(BlockView world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Optional<Boolean> hardened = blockState.getOrEmpty(AppleBlock.HARDENED);
		float hard = 0.0f;

		// 方块被破坏了，属性就被释放了
		// 不知还有什么其他方法判断
		if( hardened.isEmpty() ){
			// System.out.println("AppleBlockStat::isEmpty");
			hard = 0f;
		} else if( hardened.get() ) {
			// System.out.println("AppleBlockStat::特殊方块");
			hard = 2.0f;
		} else {
			// System.out.println("AppleBlockStat::正常方块");
			hard = 0.5f;
		}

		return hard;
	}
}