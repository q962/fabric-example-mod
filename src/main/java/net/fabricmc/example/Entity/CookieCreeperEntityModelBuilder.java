package net.fabricmc.example.Entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CookieCreeperEntityModelBuilder {
    public static Config CONFIG;

    static {
        CONFIG = new Config("CookieCreeperModel");
        CONFIG.read();
    }

    public static CookieCreeperEntityModel<CookieCreeperEntity> build(){

        //ModelPart root = CreeperEntityModel.getTexturedModelData(Dilation.NONE).createModel();

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
                }}
        );

        return new CookieCreeperEntityModel<>(root);
    }
}
