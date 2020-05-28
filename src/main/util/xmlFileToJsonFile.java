package main.util;

import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class xmlFileToJsonFile {
    public static void xmlFileToJsonFile(String xmlpath,String jsonpath) throws IOException{
        int PRETTY_PRINT_INDENT_FACTOR = 5;
        String  xmlString = new String(Files.readAllBytes(Paths.get(xmlpath)));
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);

        try (FileWriter fileWriter = new FileWriter(jsonpath)){
            fileWriter.write(xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR));
        }
    }

    public static void main(String[] args) throws IOException {
        String xmlFile = "src/main/resources/sample.xml";
        String jsonFile ="src/main/TESTRESULT/sample.json";
        xmlFileToJsonFile(xmlFile,jsonFile);
    }
}
