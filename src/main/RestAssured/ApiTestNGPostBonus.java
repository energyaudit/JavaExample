//package src.main.RestAssured;
//
//import io.restassured.config.SSLConfig;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.apache.log4j.BasicConfigurator;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import main.util.OutPutResult;
//import main.util.RTBody;
//import main.util.Str2JsonFile;
//import src.main.util.Str2JsonAppendFile;
//import com.google.gson.JsonObject;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//
//
//import java.util.HashMap;
//
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;
//import static org.openqa.selenium.support.ui.ExpectedConditions.and;
//
//
//public class ApiTestNGPostBonus {
//
//    String uri;
//    String jsonString;
//    public static   HashMap map = new HashMap();
//
//    @BeforeTest
//
//
//
//
//
//    @Test
//    public void TestResponsecode()
//    {
//        org.apache.log4j.BasicConfigurator.configure();
//        String uri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
//        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
//
//        given()
//                .when()
//                .get(uri)
//                .then()
//                .assertThat()
//                .statusCode(200);
//        // Assert.assertEquals(code,200);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("Assert API test code success");
//    }
//
//    @Test
//    public void TestResponsebdy1()
//    {
//        org.apache.log4j.BasicConfigurator.configure();
//        String uri="http://ergast.com/api/f1/2017/circuits.json";
//        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
//
//        given()
//                .when()
//                .get(uri)
//                .then()
//                .assertThat()
//                .body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
//
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("Assert API test body size success");
//    }
//    @Test
//    public void TestHeader()
//    {
//        org.apache.log4j.BasicConfigurator.configure();
//        String uri="http://ergast.com/api/f1/2017/circuits.json";
//        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
//
//        given()
//                .when()
//                .get(uri)
//                .then()
//                .assertThat()
//                .header("Content-Length",equalTo("4551"));
//
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("Assert API test header success");
//    }
//
//    @Test(dataProvider = "circuitLocations")
//    public void circuitLocationTest(String circuitId, String location) {
//        org.apache.log4j.BasicConfigurator.configure();
//        String uri="http://ergast.com/api/f1/circuits/{circuitId}.json";
//        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }
//        given().
//                pathParameters("circuitId",circuitId).
//                when().
//                get(uri).
//                then().
//                assertThat().
//                body("MRData.CircuitTable.Circuits[0].Location.country",equalTo(location));
//
//    }
//    @DataProvider(name = "circuitLocations")
//    public String[][] createCircuitTestData() {
//
//        return new String[][] {
//                {"adelaide","Australia"},
//                {"detroit","USA"},
//                {"george","South Africa"}
//        };
//    }
//
//}
