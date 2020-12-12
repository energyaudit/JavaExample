package main.RestAssured;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.util.*;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertTrue;


public class TestCallUti {
    @Test
    public void TestResponsecode() throws IOException {

        String puri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        TestCode tcd = new TestCode();
        boolean result = tcd.inputpar(puri, 200);
        assertTrue(result);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }

    @Test
    public void TestGetDataJpath() {

        String puri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        GetDataJPath gdj = new GetDataJPath();
        String result = gdj.inputpar(puri, "weather[0].main");

        Response resp = RestAssured.get(puri);
        String data = resp.getBody().asString();
        JavaUtil jul = new JavaUtil();
        String wind = jul.getFiledByJpath(data, "weather[0].main");
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("Assert API get data call getDataJpath success");
    }

    @Test
    public void testJsonSchema() {

        RestAssured.given()
                .when()
                .get("https://jsonplaceholder.typicode.com/comments?postId=1")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("src/main/resources/JsonSchemaFile.json"));

    }


    @Test
    public void TestRTsize() throws IOException {

        String puri = "http://ergast.com/api/f1/2017/circuits.json";
        RTNodeSize rts = new RTNodeSize();
        boolean result = rts.inputpar(puri, 20);
        assertTrue(result);

        int nodeSize = rts.getResponseSizebyUrl(puri, "MRData.CircuitTable.Circuits.circuitId");
        System.out.println("nodeSize is : " + nodeSize);
        Response resp = RestAssured.get(puri);
        int nodeSize1 = rts.getResSizebyResponse(resp, "MRData.CircuitTable.Circuits.circuitId");
        System.out.println("nodeSize1 is : " + nodeSize);
    }

    @Test
    public void TestbodyThenDeleteId15() {
//        String puri = "http://localhost:7000/employees";
        String puri = "http://localhost:8080/posts/";
        RestAssuredGetResponseBody rty = new RestAssuredGetResponseBody();
        String responseStr = rty.inputpar(puri);
        OutPutResult outR = new OutPutResult();
        getJsonValueByKeyJsonArray gjbj = new getJsonValueByKeyJsonArray();
        List<String> idArray = gjbj.getValuesByKeyInJSONArray(responseStr, "id");
        String id15 = idArray.get(15);
        System.out.println(idArray.size());
        System.out.println(idArray.get(15).toString());
        int id = Integer.valueOf(id15);
        System.out.println(id);
        RestAssuredDeleteById rdbyid = new RestAssuredDeleteById();
        rdbyid.RTdeleteById(puri, "", id);
    }

    @Test
    public void getByGetResponseBody() {
//        String puri = "http://localhost:7000/employees";
        String puri = "http://localhost:8080/posts/";
        ReturnResponseByGet rty = new ReturnResponseByGet();
        Response rsp = rty.inputpar(puri);
    }

    @Test
    public void getJsonNodeSize() throws IOException {
        String path = "src/main/resources/jsonNodes.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(path));
        List<JsonNode> listOfNodes = rootNode.findParents("first");
        System.out.println(listOfNodes.size());
    }

    @Test
    public void Testbody1() {
        String puri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        RestAssuredGetResponseBody rty = new RestAssuredGetResponseBody();
        rty.inputpar(puri);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data BODY success");
    }

    @Test
    public void TestShemaVerify() {
        String puri = "https://jsonplaceholder.typicode.com/posts/1";
        RTSchemaVe rty = new RTSchemaVe();
        rty.inputpar(puri, "schemaFile.json", 200);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test Test ShemaVerify success");
    }

    @Test
    public void TestAuth() {
        String puri = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RTAuthCode rty = new RTAuthCode();
        rty.inputpar(puri, "schemaFile.json", "ToolsQA", 200);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test Test AUTH success");
    }

    @Test
    public void TestResponseTime() throws IOException {
        String puri = "http://localhost:7000/employees";

        RTime rty = new RTime();
        rty.inputpar(puri);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data API Response Time success");
    }

    @Test
    public void TestResponseTime1() throws IOException {
        String puri = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        RTime rty = new RTime();
        rty.inputpar(puri);
        OutPutResult outR = new OutPutResult();
        outR.inputStr(" API test data API Response Time success");
    }

    @Test
    public void TestRTheader() throws IOException {
        String puri = "http://localhost:7000/employee";
        RTHeader rth = new RTHeader();
        boolean result = rth.inputpar(puri, "2");
        assertTrue(result);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test header content success");
    }

    @Test
    public void TestRTheader1() throws IOException {

        String puri = "http://ergast.com/api/f1/2017/circuits.json";
        RTHeader rth = new RTHeader();
        boolean result = rth.inputpar(puri, "4551");
        assertTrue(result);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test header content success");
    }


    @Test
    public void testPOSTResPath1() {
        String puri = "http://jsonplaceholder.typicode.com/posts/";
        HashMap map = new HashMap();
        map.put("userId", "2");
        map.put("id", "19");
        map.put("title", "this is projectdebug.com");
        map.put("body", "this is REST-Assured Tutorial");
        RPResPath rppt = new RPResPath();
        String rePath = rppt.inputpar(puri, map, 201, "title");
        System.out.println(rePath);
    }

    @Test
    public void testPOSTResponseBody() {
//        String puri = "http://jsonplaceholder.typicode.com";
        String puri = "http://localhost:8080/posts/";
        Random random = new Random();
        Integer inputId = random.nextInt();
        String uuid = UUID.randomUUID().toString().substring(0, 3);
        JSONObject map = new JSONObject();
        map.put("userId", inputId);
        map.put("id", inputId);
        map.put("title", "this is projectdebug.com");
        map.put("body", "this is REST-Assured Tutorial" + uuid);
        PostByBody rppt = new PostByBody();
        String rePath = rppt.inputpar(puri, map);
        System.out.println(rePath);
    }

    @Test
    public void testPOSTResponseBodyLocal() {
        String puri = "http://localhost:8080";
        Random random = new Random();
        Integer inputId = random.nextInt(10000000);
//        {
//            "name":"tammy",
//                "salary":"5000",
//                "age":"20"
//        }
        String requestBody = "{\n" +
                "  \"name\": \"tammy\",\n" +
                "  \"salary\": \"5000\",\n" +
                "  \"id\":" + inputId + ",\n" +
                "  \"age\": \"20\"\n" +
                "}";
        postResponseBody rppt = new postResponseBody();
        Response rePath = rppt.postWithPaylaod(requestBody, puri, "/posts/");
        System.out.println(rePath.getBody().asString());
    }

    @Test
    public void testPOSTResBody1() {

        String puri = "http://jsonplaceholder.typicode.com/posts/";
        HashMap map = new HashMap();
        map.put("userId", "2");
        map.put("id", "19");
        map.put("title", "this is projectdebug.com");
        map.put("body", "this is REST-Assured Tutorial");

        PostByBody rppt = new PostByBody();
        String rePath = rppt.inputpar(puri, map);
        System.out.println(rePath);
    }

    @Test
    public void testPOSTResBody2() {
        RestAssured.baseURI = "http://localhost:8080";
        Random random = new Random();
        Integer inputId = random.nextInt(10000000);
//        {
//            "name":"tammy",
//                "salary":"5000",
//                "age":"20"
//        }
        String requestBody = "{\n" +
                "  \"name\": \"tammy\",\n" +
                "  \"salary\": \"5000\",\n" +
                "  \"id\":" + inputId + ",\n" +
                "  \"age\": \"20\"\n" +
                "}";
        Response response = null;
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/posts");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
    }

    @Test
    public void TestResponsecode2() throws IOException {
        String puri = "http://localhost:7000/employees";
        TestCode tcd = new TestCode();
        boolean result = tcd.inputpar(puri, 200);
        assertTrue(result);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }

    @Test
    public void testPOSTResCode1() throws IOException {
        String puri = "http://jsonplaceholder.typicode.com/posts/";
        HashMap map = new HashMap();
        map.put("userId", "2");
        map.put("id", "19");
        map.put("title", "this is projectdebug.com");
        map.put("body", "this is REST-Assured Tutorial");
        PostCode rppt = new PostCode();
        boolean rePath = rppt.inputpar(puri, map, 201);
        System.out.println(rePath);
    }

    @Test
    public void testPOSTResCode2() throws IOException {
        String puri = "http://localhost:3000/posts";
        Random random = new Random();
        Integer inputId = random.nextInt();
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap map = new HashMap();
        map.put("id", inputId);
        map.put("title", "this is projectdebug.com");
        map.put("author", authorName);
        PostCode rppt = new PostCode();
        boolean rePath = rppt.inputpar(puri, map, 201);
        System.out.println(rePath);
    }

    @Test
    public void testPOSTResCode3() throws IOException {
        String puri = "http://localhost:8080/posts";
        Random random = new Random();
        Integer inputId = random.nextInt();
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap map = new HashMap();
        map.put("id", inputId);
        map.put("title", "this is projectdebug.com");
        map.put("author", authorName);
        PostCode rppt = new PostCode();
        boolean rePath = rppt.inputpar(puri, map, 201);
        System.out.println(rePath);
        RestAssuredGetResponseBody rty = new RestAssuredGetResponseBody();
        String puriResult = puri + "/" + inputId;
        rty.inputpar(puriResult);
    }

    @Test
    public void testPatchResCode() throws IOException {
        String puri = "http://localhost:3000/posts/1423317429";
        Random random = new Random();
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap map = new HashMap();
        map.put("author", authorName);
        PostCode rppt = new PostCode();
        boolean rePath = rppt.inputpar(puri, map, 201);
        System.out.println(rePath);
    }

    @Test
    public void delete() throws IOException {
        int id = 680039030;
        RestAssured.baseURI = "http://localhost:8080/";
        RequestSpecification request = RestAssured.given();
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");
        // Delete the request and check the response
        Response response = request.delete("/posts/" + id);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void uploadExcelFile() throws IOException {
        String path = System.getProperty("user.dir");
        String path1 = path + "/src/main/resources/source.xlsx";
        File testUploadFile = new File(path1); //Specify your own location and file
        RestAssured.baseURI = "http://localhost:5000";
//for running this test ,pls goto https://github.com/betajs/mock-file-server ,
        //npm install mock-file-server
        //node node_modules/mock-file-server/server.js
        Response response = given()
                .multiPart(testUploadFile)
                .when().post("/files");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }
    @Test
    public void test_file_uploadRealserver() {
        String path = System.getProperty("user.dir");
        String path1 = path + "/src/main/resources/employee.txt";
        File uploadFile = new File(path1);

        given()
                .log()
                .all()
                .multiPart("file", uploadFile, "multipart/form-data")
                .when()
                .post("https://jobportalkarate.herokuapp.com/normal/webapi/upload")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


    }

    @Test
    public void deleteByCallDeleteMethod() throws Exception {
        int id = 7150430;
        String puri = "http://localhost:8080/";
        RestAssuredDeleteById rdbyid = new RestAssuredDeleteById();
        rdbyid.RTdeleteById(puri, "posts", id);
    }

    @Test
    public void putRequest() throws Exception {
        int empid = 680039028;
        String puri = "http://localhost:8080/posts/" + empid;
        RequestSpecification request = RestAssured.given();
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap requestParams = new HashMap();
        requestParams.put("title", "this is projectdebug.com" + inputId);
        requestParams.put("author", authorName);
        String response = given()
                .contentType("application/json")
                .body(requestParams)
                .when()
                .put(puri).asString();
        System.out.println("The API post response is: " + response);
    }

    @Test
    public void putRequestByCallPutMethod() throws Exception {
        int empid = 1943992775;
        String puri = "http://localhost:8080/";
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap requestParams = new HashMap();
        requestParams.put("title", "this is projectdebug.com" + inputId);
        requestParams.put("author", authorName);
        RestAssuredPutWithPayload rapwp = new RestAssuredPutWithPayload();
        rapwp.inputpar(puri, requestParams, "posts/" + empid);
    }

    @Test
    public void patchRequest() throws Exception {
        int empid = 1943992775;
        String puri = "http://localhost:8080/posts/" + empid;
        String jsonString = "{\r\n" +
                "    \"title\" : \"Amod\",\r\n" +
                "    \"author\" : \"Mahajan\"}";

        //GIVEN
        RestAssured
                .given()
                .baseUri(puri)
//                .cookie("token", "6608dc75eedd44f")
                .contentType(ContentType.JSON)
                .body(jsonString)
                // WHEN
                .when()
                .patch()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("Amod"))
                .body("author", Matchers.equalTo("Mahajan"));

    }

    @Test
    public void patchRequestByMethod() throws Exception {
        int empid = 1943992775;
        String puri = "http://localhost:8080/";
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        String authorName = random.nextInt() + "billy";
        System.out.println(authorName);
        HashMap requestParams = new HashMap();
        requestParams.put("title", "this is projectdebug.com" + inputId);
        requestParams.put("author", authorName);
        RestAssuredPatch rapatch = new RestAssuredPatch();
        String path = "posts/" + empid;
        rapatch.inputpar(puri, requestParams, path);


    }

    @Test
    public void patchtest2() {
        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BAA");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users").
                then().statusCode(200);

    }

    @Test
    public void callgetJsonPathsByFieldName() throws Exception {
        File jsonFile = new File("src/main/resources/schemaFile.json").getAbsoluteFile();
        JavaUtil jul = new JavaUtil();
        String[] strArray = new String[]{"title", "userId"};
        List<String> paths = jul.getJsonPathsByFieldName("src/main/resources/schemaFile.json", strArray);
        ReadContext readContext = JsonPath.parse(jsonFile);
        for (String path : paths) {
            System.out.println("Path: " + path);
            System.out.println("Value: " + readContext.read(path));
        }
    }

    @Test
    public void callgetJsonPathsFrmJsonByFieldKey() throws Exception {
        ReadJsonFile2Str rj2s = new ReadJsonFile2Str();
        String resultO = rj2s.inputpar("src/main/resources/schemaFile.json");
        JavaUtil jul = new JavaUtil();
        String[] strArray = new String[]{"title", "userId"};
        List<String> paths = jul.getJsonPathsFrmJsonByFieldKey(resultO, strArray);
        ReadContext readContext = JsonPath.parse(resultO);
        for (String path : paths) {
            System.out.println("Path: " + path);
            System.out.println("Value: " + readContext.read(path));
        }
    }


}