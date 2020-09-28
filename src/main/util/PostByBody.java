package main.util;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
/**
 * Created by byang on 91/22/2016.
 */

public class PostByBody {


    public static String inputpar(String puri,HashMap map)  {
        org.apache.log4j.BasicConfigurator.configure();
        if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        String RespPBody=given()
                .contentType("application/json")
                .body(map)
                .when()
                .post(puri).asString();
        System.out.println("The API post response is: "+RespPBody);
        return RespPBody;
}

}
