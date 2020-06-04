package src.main.RestAssured;


        import static io.restassured.RestAssured.given;
        import static org.junit.Assert.assertTrue;

        import java.util.Random;

        import io.restassured.RestAssured;
        import main.util.OutPutResult;
        import main.util.TestCode;
        import org.hamcrest.Matchers;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import io.restassured.http.ContentType;
        import io.restassured.response.Response;

public class JsonXmlTest {




    @Test
    public void post_xml_test() {
        org.apache.log4j.BasicConfigurator.configure();
        Random random = new Random();
        String requestBody =
                "{\"id\":" +random.nextInt()+",\"name\":"+"\"Tamaki\"}";
        Response response = given().
                contentType(ContentType.XML)
        .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:7000/posts");
        System.out.println("POST Response\n" + response.asString());
             Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void post_xml_error_test() {
        org.apache.log4j.BasicConfigurator.configure();
        Response response = given().
                contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body("<empRequest>\n" +
                        "	<id>2</id>\n" +
                        "	<name>PK</name>\n" +
                        "</empRequest>")
                .when()
                .post("http://localhost:8080/My-Jersey-Project/rest/emp/getEmp");
        System.out.println("POST Error Response\n" + response.asString());
        // tests
        response.then().body("errorResponse.errorId", Matchers.is("2"));
        response.then().body("errorResponse.errorCode", Matchers.is("Wrong ID"));
        Assert.assertEquals(response.getStatusCode(),500);
    }

}
