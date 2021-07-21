package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ZombieEntityModel<T extends ZombieEntity> extends BipedEntityModel<ZombieEntity> {

    int count = 0;

    public ZombieEntityModel(ModelPart root) {
        super(root);
    }

    public boolean isAttacking(T zombieEntity) {
        return zombieEntity.isAttacking();
    }

    @Override
    protected void animateArms(ZombieEntity entity, float animationProgress) {
//        System.out.println("animateArms:"+count++);
//        super.animateArms(entity, animationProgress);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
//        return ImmutableList.of(this.body, this.rightArm, this.leftArm);
        return super.getBodyParts();
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
