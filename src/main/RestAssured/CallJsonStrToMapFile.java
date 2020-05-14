package main.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static main.util.JsonStringToMap.MaptoJsonFile;
import static main.util.JsonStringToMap.strinToMap;

public class CallJsonStrToMapFile {
    public static void main(String[] args) {
        String json = "{\"name\":\"mkyong\", \"age\":29,\"name1\":\"Kelvin\", \"age1\":19}";//map not allowed duplicated keys,so you have to name1,age1,name2,age2,....
        strinToMap(json);
//Map to JSON
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "mkyong-map1");
        map1.put("age", 29);
        map1.put("name1", "Kelvin");//if name will overwrite the last name
        map1.put("age1", 28);//if age will overwrite the last name
        // convert map to JSON string then into json file
        System.out.println("map1 is"+map1);
        MaptoJsonFile("./src/main/TESTRESULT/temp1.json", map1);
    }
}
