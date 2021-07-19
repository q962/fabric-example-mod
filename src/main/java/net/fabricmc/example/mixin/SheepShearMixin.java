package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.fabricmc.example.event.SheepShearCallback;

@Mixin(SheepEntity.class)
public class SheepShearMixin {

    @Inject(at = @At(value = "RETURN", ordinal = 0),
        method = "interactMob(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;",
        cancellable = true
    )
    private void onShear(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<ActionResult> info) {
        /* ActionResult result = */SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this);

        info.setReturnValue(ActionResult.FAIL);
    }
}