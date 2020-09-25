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

public class ResponseBody {
  static  RequestSpecification httpRequest;
   static Response response;
    public static Response  getWithHeaders(Map head, String puri, String path)  {
        RestAssured.baseURI = puri;
        httpRequest = RestAssured.given();
//        httpRequest.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGciLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiNDNlNGNjN2EtMzgzNy00YmUzLTgxMzgtNjJhNjg3NzY1ZDMwLTExNjc2NTU0IiwiaXNzIjoiaHR0cHM6Ly8zLjgzLjEyMS40MjoxMDQ0My9hbS9vYXV0aDIvVmVyaWZvbmVVc2VycyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlU2VE1iXzhDYWx1QVlnNWhZel9rLTB6UVdDdyIsImF1ZCI6ImVudGl0eUNsaWVudCIsIm5iZiI6MTU5NzQwMTIwNiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNTk3NDAwMDcxLCJyZWFsbSI6Ii9WZXJpZm9uZVVzZXJzIiwiZXhwIjoxNTk3NDA0ODA2LCJpYXQiOjE1OTc0MDEyMDYsImV4cGlyZXNfaW4iOjM2MDAsImp0aSI6ImRWRHk5cG05M0h0VDEwU2FCeWx2TDZ6TzdFVSIsImVudGl0eV9pZCI6IjFhMDE4ZWIwLWM5NTItNDM0MS1hMzY0LTUxOWM4NGE3NDNkZSIsInJvbGVzIjpbIk1FUkNIQU5UX0FETUlOIl0sInVzZXJVaWQiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGcifQ.9maksYbw6tuSVFELaRrX6YZ7oX2gh9ZeCFmRJMk2ylQ");
//        httpRequest.header("Content-Type", "application/json");
//        httpRequest.header("Accept", "*/* ");
        HashMap<String, Object> headers = new HashMap<String, Object>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGciLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXV0aF9sZXZlbCI6MCwiYXVkaXRUcmFja2luZ0lkIjoiNDNlNGNjN2EtMzgzNy00YmUzLTgxMzgtNjJhNjg3NzY1ZDMwLTExNjc2NTU0IiwiaXNzIjoiaHR0cHM6Ly8zLjgzLjEyMS40MjoxMDQ0My9hbS9vYXV0aDIvVmVyaWZvbmVVc2VycyIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlU2VE1iXzhDYWx1QVlnNWhZel9rLTB6UVdDdyIsImF1ZCI6ImVudGl0eUNsaWVudCIsIm5iZiI6MTU5NzQwMTIwNiwiZ3JhbnRfdHlwZSI6ImF1dGhvcml6YXRpb25fY29kZSIsInNjb3BlIjpbIm9wZW5pZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNTk3NDAwMDcxLCJyZWFsbSI6Ii9WZXJpZm9uZVVzZXJzIiwiZXhwIjoxNTk3NDA0ODA2LCJpYXQiOjE1OTc0MDEyMDYsImV4cGlyZXNfaW4iOjM2MDAsImp0aSI6ImRWRHk5cG05M0h0VDEwU2FCeWx2TDZ6TzdFVSIsImVudGl0eV9pZCI6IjFhMDE4ZWIwLWM5NTItNDM0MS1hMzY0LTUxOWM4NGE3NDNkZSIsInJvbGVzIjpbIk1FUkNIQU5UX0FETUlOIl0sInVzZXJVaWQiOiI2OTVhZGQxYi00NmY2LTQwNWItYWVmMy05NjBkNzkyNzA2OGcifQ.9maksYbw6tuSVFELaRrX6YZ7oX2gh9ZeCFmRJMk2ylQ");
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "*/*");
        System.out.println("The header is:  "+headers);
        Iterator var = ((Set)headers.keySet().stream().collect(Collectors.toSet())).iterator();
        while(var.hasNext()) {
            String headerKey = (String)var.next();
            httpRequest.header(headerKey, headers.get(headerKey));
        }
        response = httpRequest.request(Method.GET, "/v1/hierarchy/");
        System.out.println("The hiararchy reponse is:  "+response.getBody().asString());
        return response;
    }

}
