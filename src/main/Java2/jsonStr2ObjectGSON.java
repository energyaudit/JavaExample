package main.Java2;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class jsonStr2ObjectGSON {
    public static void main(String args[]) {
        JsonParser parser = new JsonParser();
        String json = "{ \"f1\":\"Hello\",\"f2\":{\"f3:\":\"World\"}}";
        JsonElement jsonTree = parser.parse(json);
        System.out.println("jsontree"+jsonTree);
        if(jsonTree.isJsonObject()){
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            JsonElement f1 = jsonObject.get("f1");
            System.out.println("f1"+f1);
            JsonElement f2 = jsonObject.get("f2");
            System.out.println("f2"+f2);
            if(f2.isJsonObject()){
                JsonObject f2Obj = f2.getAsJsonObject();
                JsonElement f3 = f2Obj.get("f3");
                System.out.println("f3"+f3);
            }

        }

    }
}