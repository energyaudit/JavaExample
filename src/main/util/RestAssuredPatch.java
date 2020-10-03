package main.util;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestAssuredPatch {
    public static Response inputpar(String puri, HashMap map, String path)  {
        RestAssured.baseURI = puri;
        org.apache.log4j.BasicConfigurator.configure();
        if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
        Response response = null;
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(map)
                    .patch(path);
             } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        return response;
    }
}
