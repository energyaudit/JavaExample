package main.RestAssured;

import main.util.fileExistManager;
import main.util.fileNoExistException;

import java.util.HashMap;
import java.util.Map;

import static main.util.FilePermit.setFilePermit;
import static main.util.JsonStringToMapToJson.MaptoJsonFile;
import static main.util.fileExistManager.find;

public class VerfiyMapFileExist {
    public static void main(String[] args) {
String fpath="./src/main/TESTRESULT/vlad.json";
//Map to JSON
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("Apple", "a fruit, a tech firm");
        map1.put("Table", "an object, contains rows and columns when used in context of computers");
        map1.put("Orange", "a fruit");
        // convert map to JSON string then into json file
        MaptoJsonFile(fpath, map1);
        setFilePermit(fpath,true,true,true);
//   fileExistPath(fpath) ;
        fileExistManager manage = new fileExistManager();
        try {
            find(fpath);
            find("./src/main/TESTRESULT/vlad1.json");
        } catch (fileNoExistException ex) {
            System.err.print(ex);
        }
    }

    }

