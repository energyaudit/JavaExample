package main.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by byang on 2018-09-19.
 */

public class JsonStringToMapToJson {
    public static void MaptoJsonFile(String filepath, Map mapinput) {//no need Map<T,T>
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json1 = "";
            // convert map to JSON string then into json file
            json1 = mapper.writeValueAsString(mapinput);
            System.out.println("writeValueAsString:  "+json1);
            json1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapinput);
            // pretty print
            System.out.println("writeValueWithPrettyPrinter: "+json1);
            FileWriter w = new FileWriter(filepath);
            BufferedWriter out = new BufferedWriter(w);
            out.newLine();
            out.write(json1);
            out.flush();
            out.close();

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map strinToMap(String str) {
//       Map<String, Object> map = new HashMap<String, Object>();
        Map map = new HashMap<>();
           try {
            ObjectMapper mapper = new ObjectMapper();
            // convert JSON string to Map
            map = mapper.readValue(str, new TypeReference<Map<String, String>>() {
            });
            System.out.println("Print map directly: "+map);
                 } catch (IOException e) {
            e.printStackTrace();
        }
           return map;
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"mkyong\", \"age\":29}";
        strinToMap(json);
//Map to JSON
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "mkyong-map1");
        map1.put("age", 29);
        // convert map to JSON string then into json file
        MaptoJsonFile("./src/main/TESTRESULT/temp1.json", map1);
    }
}





