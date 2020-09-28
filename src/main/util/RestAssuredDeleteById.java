package main.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
/**
 * Created by byang on 91/26/2016.
 */
public class RestAssuredDeleteById {
    public static void RTdeleteById(String puri,String path,Integer id) {
        RestAssured.baseURI = puri;
        RequestSpecification request = RestAssured.given();
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");
        // Delete the request and check the response
        Response response = request.delete(path +"/"+ id);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }
}
