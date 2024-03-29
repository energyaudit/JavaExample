package main.util;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by byang on 91/22/2016.
 */

public class RestAssuredGetResponseBody {
    public static boolean vrf;

    public static String inputpar(String puri)  {

//        try {
        org.apache.log4j.BasicConfigurator.configure();
        if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        Response resp= RestAssured.get(puri);
        String data=resp.asString();
        System.out.println(data);
        String jsonString=data;

        try {
            FileWriter writer = new FileWriter("src/main/TESTRESULT/temp.json");
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Response time:"+resp.getTime());
              return data;
    }

}
