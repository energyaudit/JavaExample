package main.RestAssured;


import java.io.File;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import com.fasterxml.jackson.core.type.TypeReference;
        import com.fasterxml.jackson.databind.ObjectMapper;

public class map2JsonFileDirectly {

    public static void main(String args[]) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> carMap = new HashMap<String, Object>();
        carMap.put("car", "Audi");
        carMap.put("price", "30000");
        carMap.put("model", "2010");

        List<String> colors = new ArrayList<String>();
        colors.add("Grey");
        colors.add("White");
        colors.add("Black");
        carMap.put("colors", colors);
        /**
         * Convert Map to JSON and write to a file
         */
        try {
            mapper.writeValue(new File("src/main/TESTRESULT/payload.json"), carMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}