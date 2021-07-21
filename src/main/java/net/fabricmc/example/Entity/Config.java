
package net.fabricmc.example.Entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import net.minecraft.client.model.ModelPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Config {
    public static final Path word_path;
    public static class Data{
        public static final Data instance = new Data();

        // -------UV：指一个平面内的贴图缩放比，默认比 1
        // UV: 贴图偏移值
        @JSONField(name = "u")
        public int u = 0;
        @JSONField(name = "v")
        public int v = 0;
        @JSONField(name = "x")
        public float x = 0;
        @JSONField(name = "y")
        public float y = 0;
        @JSONField(name = "z")
        public float z = 0;
        //
        /**
         * size 和 extra 的关系
         * extra 使用起来像放大
         * 结果就是
         */
        @JSONField(name = "sizeX")
        public float sizeX = 0;
        @JSONField(name = "sizeY")
        public float sizeY = 0;
        @JSONField(name = "sizeZ")
        public float sizeZ = 0;
        //
        @JSONField(name = "extraX")
        public float extraX = 0;
        @JSONField(name = "extraY")
        public float extraY = 0;
        @JSONField(name = "extraZ")
        public float extraZ = 0;
        @JSONField(name = "mirror")
        public boolean mirror = false;
        @JSONField(name = "textureWidth")
        public float textureWidth = 0;
        @JSONField(name = "textureHeight")
        public float textureHeight = 0;
        @JSONField(name = "pivotX")
        public float pivotX = 0;
        @JSONField(name = "pivotY")
        public float pivotY = 0;
        @JSONField(name = "pivotZ")
        public float pivotZ = 0;
        
        public ModelPart.Cuboid toCuboid(){
            return new ModelPart.Cuboid(
                this.u,
                this.v,
                this.x,
                this.y,
                this.z,
                this.sizeX,
                this.sizeY,
                this.sizeZ,
                this.extraX,
                this.extraY,
                this.extraZ,
                this.mirror,
                this.textureWidth,
                this.textureHeight
            );
        }
        public ModelPart toModelPart(){
            var a = new ModelPart(
                    new ArrayList<ModelPart.Cuboid>(
                            Collections.singletonList(
                                    toCuboid()
                            )
                    ),
                    new HashMap<String, ModelPart>()
            );
            a.setPivot(this.pivotX,this.pivotY,this.pivotZ);
            return a;
        }
    }

    private String json_file_path;
    private Map<String, Data> data;
    private String name;

    static {

        word_path =  Paths.get(System.getProperty("user.dir"));
        File file = new File(Paths.get(word_path.toString(), "assets").toString());
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }

    }

    public Config(String _name) {
        this.name = _name;
        this.data = new HashMap<>();

        File file = new File(Paths.get(word_path.toString(), "assets", _name+".json").toString());
        json_file_path = file.getPath();

        if(!file.exists()){//如果文件夹不存在
            try {
                file.createNewFile();
            } catch(IOException e) {
                //pass
            }
        }
    }

    public void read() {

        try {
            JSONObject jsonObject = JSON.parseObject(
                    new FileInputStream(json_file_path),
                    null
            );
            if(jsonObject.isEmpty()){
                this.data = null;
                return;
            }
            for (Map.Entry<String, ?> entry : jsonObject.entrySet()) {
                this.data.put( entry.getKey(), JSON.parseObject(
                        entry.getValue().toString(),
                        Data.class
                ));
            }

        } catch (Exception e) {

            try {
                JSONObject jsonObject = JSON.parseObject(
                        Objects.requireNonNull(
                                this.getClass().getResourceAsStream("/"+this.name + ".json")
                        ),
                        null
                );
                if(jsonObject.isEmpty()){
                    this.data = null;
                    return;
                }
                for (Map.Entry<String, ?> entry : jsonObject.entrySet()) {
                    this.data.put( entry.getKey(), JSON.parseObject(
                            entry.getValue().toString(),
                            Data.class
                    ));
                }

            } catch (Exception e2) {
                this.data = null;
            }
        }
    }

    public Data get(String key){
        if( data == null ){
            return Data.instance;
        } else
            return data.getOrDefault(key, Data.instance);
    }

}
