package main.RestAssured;


import com.jayway.jsonpath.EvaluationListener;
        import com.jayway.jsonpath.JsonPath;
        import com.jayway.jsonpath.ReadContext;
import main.util.ReadJsonFile2Str;

import java.io.File;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class findJsonByValue {
    public static void main(String[] args) throws Exception {
//        File jsonFile = new File("src/main/resources/schemaFile.json").getAbsoluteFile();
        ReadJsonFile2Str rj2s = new ReadJsonFile2Str();
        String resultO = rj2s.inputpar("src/main/resources/schemaFile.json");
        List<String> paths = new ArrayList<>();
//        ReadContext findPathsContext = JsonPath.parse(jsonFile).withListeners((found) -> {
        ReadContext findPathsContext = JsonPath.parse(resultO).withListeners((found) -> {
            paths.add(found.path());
            return EvaluationListener.EvaluationContinuation.CONTINUE;
        });

        List<String> properties = Arrays.asList("title", "userId");
        properties.forEach(p -> findPathsContext.read("$.." + p));
//        ReadContext readContext = JsonPath.parse(jsonFile);
        ReadContext readContext = JsonPath.parse(resultO);
        for (String path : paths) {
            System.out.println("Path: " + path);
            System.out.println("Value: " + readContext.read(path));
        }
    }
}