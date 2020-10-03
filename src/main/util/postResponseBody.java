package main.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by byang on 91/22/2016.
 */

public class postResponseBody {
    static  RequestSpecification httpRequest;
     public static Response  postWithPaylaod(String requestBody,String puri, String path)  {
         RestAssured.baseURI = puri;
        Response response = null;
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        return response;
    }

}

