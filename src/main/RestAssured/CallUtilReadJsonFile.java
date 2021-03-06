package main.RestAssured;

import com.google.common.io.CharStreams;
import main.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import main.util.ReadJsonFile2Str;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;


public class CallUtilReadJsonFile {
    @Test
    public void CallUtilReadJsonFile() {
        ReadJsonFile2Str rj2s = new ReadJsonFile2Str();
        String resultO = rj2s.inputpar("src/main/TESTRESULT/user2.json");

        System.out.println("Before Update " + resultO);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }

    @Test
    public void CallUtilReadJsonFile1() {
        ReadJsonFile2Str rj2s = new ReadJsonFile2Str();
        String resultO = rj2s.inputpar("src/main/TESTRESULT/user2.json");
        System.out.println("Before Update " + resultO);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }



    @Test
    public void CallUtilReadJsonFileFromResource() throws Exception {
        ReadJsonFileResource rj2s = new ReadJsonFileResource();
        String resultO = rj2s.inputpar("projectname/ent2e.json");
        System.out.println("Before Update " + resultO);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Read json file from resource folder success");
    }

    @Test
    public void givenFileNameAsAbsolutePath_whenUsingClasspath_thenFileData() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("ent1e.json");
        String text = null;
        try (final Reader reader = new InputStreamReader(inputStream)) {
            text = CharStreams.toString(reader);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(text);
    }

    @Test
    public void Classpath_FileData() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("projectname/ent2e.json");
        String text = null;
        try (final Reader reader = new InputStreamReader(inputStream)) {
            text = CharStreams.toString(reader);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(text);
    }

    @Test
    public void AnalyzeJsonFile() {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        JSONObject obj;
        // The name of the file to open.
        String fileName = "src/main/TESTRESULT/testout1.txt";

        // This will reference one line at a time
        String line = null;
        ArrayList<String> list = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                json.add(obj);
                System.out.println((Long) obj.get("dieVersion") + ":" +
                        (Long) obj.get("value"));
                String result = obj.get("value").toString();
                list.add(result);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        CountListFreq clf = new CountListFreq();
        Map outMp = clf.countArrayListElementFrequencies(list);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data analysis result success");
    }

    @Test
    public void Call1GetJsonFileValueByName() {
        GetJsonFileValueByName gjv = new GetJsonFileValueByName();
        ArrayList alst = gjv.inputStr("src/main/TESTRESULT/testout1.txt", "value");

        CountListFreq clf = new CountListFreq();
        Map outMp = clf.countArrayListElementFrequencies(alst);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data analysis result success");
    }

    @Test
    public void Call2GetJsonFileValueByName() {
        GetJsonFileValueByName gjv = new GetJsonFileValueByName();
        //    ArrayList alst = gjv.inputStr("C:\\QA\\TESTRESULT\\Dump\\testout2.txt", "value");
        ArrayList alst = gjv.inputStr("src/main/TESTRESULT/testout2.txt", "value");


        CountListFreq clf = new CountListFreq();
        Map outMp = clf.countArrayListElementFrequencies(alst);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data analysis result success");
    }

    @Test
    public void Call3GetJsonFileValueByName() {
        GetJsonFileValueByName gjv = new GetJsonFileValueByName();
        ArrayList alst = gjv.inputStr("src/main/TESTRESULT/testout3.txt", "value");
        CountListFreq clf = new CountListFreq();
        Map outMp = clf.countArrayListElementFrequencies(alst);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data analysis result success");
    }


}
