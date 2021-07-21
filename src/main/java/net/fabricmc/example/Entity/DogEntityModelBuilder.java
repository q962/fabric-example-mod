package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DogEntityModelBuilder {
    public static Config CONFIG;

    static {
        CONFIG = new Config("DogModel");
        CONFIG.read();
    }
    public static DogEntityModel<DogEntity> build(){

        //ModelPart root = SpiderEntityModel.getTexturedModelData().createModel();

        ModelPart root = new ModelPart(
                new ArrayList<ModelPart.Cuboid>(
                        Collections.singletonList(
                                CONFIG.get("main").toCuboid()
                        )
                ),
                new HashMap<>() {{
                    put(EntityModelPartNames.HEAD, CONFIG.get(EntityModelPartNames.HEAD).toModelPart());
                    put(EntityModelPartNames.LEFT_HIND_LEG, CONFIG.get(EntityModelPartNames.LEFT_HIND_LEG).toModelPart());
                    put(EntityModelPartNames.RIGHT_HIND_LEG, CONFIG.get(EntityModelPartNames.RIGHT_HIND_LEG).toModelPart());
                    put(EntityModelPartNames.RIGHT_FRONT_LEG, CONFIG.get(EntityModelPartNames.RIGHT_FRONT_LEG).toModelPart());
                    put(EntityModelPartNames.LEFT_FRONT_LEG, CONFIG.get(EntityModelPartNames.LEFT_FRONT_LEG).toModelPart());
                    put("right_middle_hind_leg", CONFIG.get("right_middle_hind_leg").toModelPart());
                    put("left_middle_hind_leg", CONFIG.get("left_middle_hind_leg").toModelPart());
                    put("right_middle_front_leg", CONFIG.get("right_middle_front_leg").toModelPart());
                    put("left_middle_front_leg", CONFIG.get("left_middle_front_leg").toModelPart());
                    put("body0", CONFIG.get("body0").toModelPart());
                    put("body1", CONFIG.get("body1").toModelPart());
                }}
        );

        return  new DogEntityModel<>(root);
    }
}
