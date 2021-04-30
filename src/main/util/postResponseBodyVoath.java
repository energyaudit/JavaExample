package main.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Created by byang on 91/22/2016.
 */

public class postResponseBodyVoath {
    static  RequestSpecification httpRequest;
    static Response response;
    public static Response  postWithPaylaod(String requestBody,String puri, String token)  {
        Response response = null;
        try {
            response = RestAssured.given().
            auth().
                    preemptive().
                    oauth2(token).
                    header("Accept", ContentType.JSON.getAcceptHeader())
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(puri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        return response;
    }

}

