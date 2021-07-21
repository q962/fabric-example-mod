package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ZombieEntityModelBuilder {
    public static Config CONFIG;

    static {
        CONFIG = new Config("ZombieModel");
        CONFIG.read();
    }

    public static ZombieEntityModel<ZombieEntity> build() {

        //ModelPart root = net.minecraft.client.render.entity.model.ZombieEntityModel
        //        .getModelData(Dilation.NONE, 0)
        //        .getRoot()
        //        .createPart((int)CONFIG.get("main").textureWidth, (int)CONFIG.get("main").textureHeight);

        ModelPart root = new ModelPart(
                new ArrayList<ModelPart.Cuboid>(
                        Collections.singletonList(
                                CONFIG.get("main").toCuboid()
                        )
                ),

                new HashMap<String, ModelPart>(){{
                    put(EntityModelPartNames.HEAD, CONFIG.get(EntityModelPartNames.HEAD).toModelPart());
                    put(EntityModelPartNames.HAT, CONFIG.get(EntityModelPartNames.HAT).toModelPart());
                    put(EntityModelPartNames.BODY, CONFIG.get(EntityModelPartNames.BODY).toModelPart());
                    put(EntityModelPartNames.RIGHT_ARM, CONFIG.get(EntityModelPartNames.RIGHT_ARM).toModelPart());
                    put(EntityModelPartNames.LEFT_ARM, CONFIG.get(EntityModelPartNames.LEFT_ARM).toModelPart());
                    put(EntityModelPartNames.RIGHT_LEG, CONFIG.get(EntityModelPartNames.RIGHT_LEG).toModelPart());
                    put(EntityModelPartNames.LEFT_LEG, CONFIG.get(EntityModelPartNames.LEFT_LEG).toModelPart());
                }}
        );

        return new ZombieEntityModel<>(root);
    }
}
