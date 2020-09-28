package src.main.RestAssured;

import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import main.util.OutPutResult;
import main.util.RestAssuredGetResponseBody;
import main.util.Str2JsonFile;

public class GetData1 {
    @Test
    public void TestResponsecode()
    {
        org.apache.log4j.BasicConfigurator.configure();
        String uri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200);
        // Assert.assertEquals(code,200);
        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test code success");
    }
    @Test
    public void Testbody()
    {
        org.apache.log4j.BasicConfigurator.configure();
        String uri="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        //   Response resp= src.main.RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        Response resp= get(uri);
        String data=resp.getBody().asString();
        System.out.println(data);
        System.out.println("Response time:"+resp.getTime());
        RestAssuredGetResponseBody rty= new RestAssuredGetResponseBody();
        String jsonString=rty.inputpar(uri);
        Str2JsonFile sjf=new Str2JsonFile();
        //     sjf.inputStr(jsonString,"C:\\QA\\TESTRESULT\\temp.json");
        sjf.inputStr(jsonString,"src/main/TESTRESULT/temp.json");
        JsonPath jsonPath=new JsonPath(data);
        String weat=jsonPath.getString("weather[0].main");
        System.out.println(weat);

        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test data success");
    }
    @Test
    public void TestResponsebdy1()
    {
        org.apache.log4j.BasicConfigurator.configure();
        String uri="http://ergast.com/api/f1/2017/circuits.json";
        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));

        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test body size success");
    }
    @Test
    public void TestHeader()
    {
        org.apache.log4j.BasicConfigurator.configure();
        String uri="http://ergast.com/api/f1/2017/circuits.json";
        if(uri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        given()
                .when()
                .get(uri)
                .then()
                .assertThat()
                .header("Content-Length",equalTo("4551"));

        OutPutResult outR = new OutPutResult();
        outR.inputStr("Assert API test header success");
    }


}
