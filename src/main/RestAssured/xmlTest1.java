package main.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class xmlTest1 {

    @Test
    public void xmlPostRequest_Test() {
        org.apache.log4j.BasicConfigurator.configure();
        RestAssured.baseURI = "http://localhost:7000";

//        String requestBody = "<client>\r\n" +
//                "    <clientNo>100</clientNo>\r\n" +
//                "    <name>Tom Cruise</name>\r\n" +
//                "    <ssn>124-542-5555</ssn>\r\n" +
//                "</client>";
        Random random = new Random();
        String requestBody =
                "{\"name\": \"Lisa "+random.nextInt()+"Tamaki\"}";

        Response response = null;

        response = given().
//                contentType(ContentType.XML)
           contentType(ContentType.JSON)
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
//                .post("/addClient");
                .post("/actor");

        System.out.println("Post Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
//        System.out.println("Does Reponse contains 'Lisa Tamaki'? :" + response.asString().contains("Lisa Tamaki"));
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
