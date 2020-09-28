package main.util;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by byang on 91/22/2016.
 */

public class getResponseBody {
    static  RequestSpecification httpRequest;
    static Response response;
    public static Response  getWithHeaders(Map headers, String puri, String path)  {
        RestAssured.baseURI = puri;
        httpRequest = RestAssured.given();
        System.out.println("The header is:  "+headers);
        Iterator var = ((Set)headers.keySet().stream().collect(Collectors.toSet())).iterator();
        while(var.hasNext()) {
            String headerKey = (String)var.next();
            httpRequest.header(headerKey, headers.get(headerKey));
        }
//        response = httpRequest.request(Method.GET, path);

        response = httpRequest.request(Method.GET, path);
        System.out.println("The reponse is:  "+response.getBody().asString());
        return response;
    }

}

