package net.fabricmc.example.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

public class EventBoxBlock extends SandBlock{

	public EventBoxBlock(int color, Settings settings) {
		super(color, settings);
	}
	// 服务器端触发
	// 放置方块会触发
	// 下落会触发
	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		super.onBlockAdded(state, world, pos, oldState, notify);

		if( world.isClient() ){
			System.out.println("client: onBlockAdded");
		} else {
			System.out.println("server: onBlockAdded");
		}
	}
	// 破坏开始
	// 左键单击
	@Override
	public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
		super.onBlockBreakStart(state, world, pos, player);

		if( world.isClient() ){
			System.out.println("client: onBlockBreakStart");
		} else {
			System.out.println("server: onBlockBreakStart");
		}
	}
	// 方块被破坏1
	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		super.onBreak(world, pos, state, player);

		if( world.isClient() ){
			System.out.println("client: onBreak");
		} else {
			System.out.println("server: onBreak");
		}
	}
	// 方块被破坏2
	@Override
	public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
		super.onBroken(world, pos, state);

		System.out.println("onBroken");
	}
	// 被爆w物摧毁的
	@Override
	public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		super.onDestroyedByExplosion(world, pos, explosion);

		if( world.isClient() ){
			System.out.println("client: onDestroyedByExplosion");
		} else {
			System.out.println("server: onDestroyedByExplosion");
		}
	}
	// 实体碰撞
	// 在有掉落物的地方放置方块 会触发
	// 与 掉落物发生的碰撞
	// 弓箭命中也会触发
	@Override
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(state, world, pos, entity);

		if( world.isClient() ){
			System.out.println("client: onEntityCollision");
		} else {
			System.out.println("server: onEntityCollision");
		}
	}
	// 在方块上
	// 掉落物也会触发
	// 生物也会触发
	// 持续触发
	// 潜行触发
	@Override
	public void onEntityLand(BlockView world, Entity entity) {
		super.onEntityLand(world, entity);

		System.out.println("onEntityLand");
	}
	// 在方块上
	// 潜行不触发
	// 掉落物也会触发
	// 生物也会触发
	// 持续触发函数
	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		super.onSteppedOn(world, pos, state, entity);

		if( world.isClient() ){
			System.out.println("client: onSteppedOn");
		} else {
			System.out.println("server: onSteppedOn");
		}
	}
	// 降落接触
	// 生物高处落地
	// 物品丢弃高处落地
	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.onLandedUpon(world, state, pos, entity, fallDistance);

		if( world.isClient() ){
			System.out.println("client: onLandedUpon");
		} else {
			System.out.println("server: onLandedUpon");
		}
	}
	// 放置方块
	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);

		if( world.isClient() ){
			System.out.println("client: onPlaced");
		} else {
			System.out.println("server: onPlaced");
		}
	}
	// 弓箭命中
	@Override
	public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
		super.onProjectileHit(world, state, hit, projectile);

		if( world.isClient() ){
			System.out.println("client: onProjectileHit");
		} else {
			System.out.println("server: onProjectileHit");
		}
	}
	// 服务器端
	// 方块被移动
	// 活塞推动
	// 爆炸破坏也触发
	@Override
	public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
		super.onStateReplaced(state, world, pos, newState, moved);

		if( world.isClient() ){
			System.out.println("client: onStateReplaced");
		} else {
			System.out.println("server: onStateReplaced");
		}
	}
	// 右击
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {

		if( world.isClient() ){
			System.out.println("client: onUse");
		} else {
			System.out.println("server: onUse");
		}

		return super.onUse(state, world, pos, player, hand, hit);
	}


	@Override
	public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
		super.onDestroyedOnLanding(world, pos, fallingBlockEntity);

		if( world.isClient() ){
			System.out.println("client: onDestroyedOnLanding");
		} else {
			System.out.println("server: onDestroyedOnLanding");
		}
	}
	@Override
	public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos,
			FallingBlockEntity fallingBlockEntity) {
		super.onLanding(world, pos, fallingBlockState, currentStateInPos, fallingBlockEntity);

		if( world.isClient() ){
			System.out.println("client: onLanding");
		} else {
			System.out.println("server: onLanding");
		}
	}
	@Override
	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);

		System.out.println("onStacksDropped");
	}
	@Override
	public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
		if( world.isClient() ){
			System.out.println("client: onSyncedBlockEvent");
		} else {
			System.out.println("server: onSyncedBlockEvent");
		}

		return super.onSyncedBlockEvent(state, world, pos, type, data);
	}
}
