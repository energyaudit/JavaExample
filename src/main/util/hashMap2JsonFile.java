package main.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class hashMap2JsonFile {

    public static void hashMap2JsonFileMethod(Map map,String path){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        Map<String, Object> carMap = new HashMap<String, Object>();
        String uuid = UUID.randomUUID().toString().substring(0,6);
        carMap.put("car", "Audi");
        carMap.put("price", inputId);
        carMap.put("model", uuid);

        List<String> colors = new ArrayList<String>();
        colors.add("Grey");
        colors.add("White");
        colors.add("Black");
        carMap.put("colors", colors);
String path="src/main/TESTRESULT/payload.json";
        hashMap2JsonFileMethod(carMap,path);


    }
}
