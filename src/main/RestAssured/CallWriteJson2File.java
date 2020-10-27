package main.RestAssured;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import main.util.OutPutResult;
import main.util.JsonStr2JsonFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static main.util.hashMap2JsonFile.hashMap2JsonFileMethod;


public class CallWriteJson2File {
    @Test
    public void TestResponsecode() {
        org.apache.log4j.BasicConfigurator.configure();
        String uri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if (uri.toLowerCase().contains("https")) {
            RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
        }

        //   Response resp= src.main.RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        Response resp = RestAssured.get(uri);
        int code = resp.getStatusCode();
        System.out.print(code);
        Assert.assertEquals(code, 200);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }

    @Test
    public void Testbody() {
        org.apache.log4j.BasicConfigurator.configure();
        String uri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if (uri.toLowerCase().contains("https")) {
            RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
        }

        //   Response resp= src.main.RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        Response resp = RestAssured.get(uri);
        String data = resp.asString();
        System.out.println(data);
        System.out.println("Response time:" + resp.getTime());

        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test data success");
    }

    @Test
    public void TestbodyJsonFile() {
        org.apache.log4j.BasicConfigurator.configure();
        String uri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if (uri.toLowerCase().contains("https")) {
            RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
        }

        //   Response resp= src.main.RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        Response resp = RestAssured.get(uri);
        String jsonString = resp.asString();

        try {
            //   FileWriter writer = new FileWriter("C:\\QA\\TESTRESULT\\temp.json");
            FileWriter writer = new FileWriter("src/main/TESTRESULT/temp.json", true);

            writer.write(jsonString);
            writer.close();
//            FileWriter w = new FileWriter("C:\\QA\\TESTRESULT\\temp.json");
//            BufferedWriter out = new BufferedWriter(w);
//            out.newLine();
//            out.write(jsonString);
//            out.flush();
//            out.close();

        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Response time:" + resp.getTime());
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test data write to jason file success");
    }

    @Test
    public void TesCallWriteJsonFile() {
        org.apache.log4j.BasicConfigurator.configure();
        String uri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if (uri.toLowerCase().contains("https")) {
            RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
        }

        //   Response resp= src.main.RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        Response resp = RestAssured.get(uri);
        String jsonString = resp.asString();

        JsonStr2JsonFile sjf = new JsonStr2JsonFile();
        sjf.inputStr(jsonString, "src/main/TESTRESULT/temp.json");
        System.out.println("Response time:" + resp.getTime());
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test data write to jason file success" + jsonString);
    }

    @Test
    public void TesCallWriteJsonFileStr() {
        String inline = "{ \"results\":{\"brand\" : \"Mercedes\", \"doors\" : 5," +
                "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                "  \"nestedObject\" : { \"field\" : \"value\" } }}";
        JsonStr2JsonFile sjf=new JsonStr2JsonFile();
        sjf.inputStr(inline,"src/main/TESTRESULT/temp1.json");
    }

    @Test
    public void TesCallWriteJsonFile1() {
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap requestParams = new HashMap();
        requestParams.put("title", "this is projectdebug.com" + inputId);
        requestParams.put("author", authorName);
        String jsonString = requestParams.toString();
        JsonStr2JsonFile sjf = new JsonStr2JsonFile();
        sjf.inputStr(jsonString, "src/main/TESTRESULT/payload.json");
    }

    @Test
    public void TesCallMap2Jsonfile() {
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
