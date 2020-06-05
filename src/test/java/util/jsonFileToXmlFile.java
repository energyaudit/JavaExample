package util;

import org.json.JSONObject;
import org.json.XML;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class jsonFileToXmlFile {
    public static void jsonFileToXmlFile(String jsonpath,String xmlpath) throws IOException{
        String jsonStr = new String(Files.readAllBytes(Paths.get(jsonpath)));
        JSONObject json = new JSONObject(jsonStr);

        try (FileWriter fileWriter = new FileWriter(xmlpath)) {
            fileWriter.write(XML.toString(json));
        }
    }
    public static void main(String[] args) throws IOException {
        String jsonFile = "src/main/resources/schemaFile.json";
        String xmlFile = "src/main/TESTRESULT/schemaFile.xml";
jsonFileToXmlFile(jsonFile,xmlFile);
    }
}
