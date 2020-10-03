package main.util;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;

/**
 * Created by byang on 91/22/2016.
 */

public class RestAssuredPutWithPayload {


    public static Response inputpar(String puri, HashMap requestParams, String path)  {
        RestAssured.baseURI = puri;
        org.apache.log4j.BasicConfigurator.configure();
        if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
        Response response=null;
        try {
        response=RestAssured.given()
                .contentType("application/json")
                .body(requestParams)
                .when()
                .put(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        return response;
}

}
