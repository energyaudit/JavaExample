package main.RestAssured;

import java.io.IOException;

import static main.util.jsonFileToXmlFile.jsonFileToXmlFile;
import static main.util.xmlFileToJsonFile.xmlFileToJsonFile;

public class xmlToFrmJson {
    public static void main(String[] args) throws IOException {
        String xmlFile = "src/main/resources/sample.xml";
        String jsonFile ="src/main/TESTRESULT/sample.json";
        xmlFileToJsonFile(xmlFile,jsonFile);

        String jsonFile1 = "src/main/resources/schemaFile.json";
        String xmlFile1 = "src/main/TESTRESULT/schemaFile.xml";
        jsonFileToXmlFile(jsonFile1,xmlFile1);


    }
}
