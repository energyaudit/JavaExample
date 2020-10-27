package main.util;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * Created by byang on 91/26/2016.
 */

public class RTNodeSize {
    public static boolean vrf;

    public static boolean inputpar(String puri,int size) throws IOException {

        try {
            org.apache.log4j.BasicConfigurator.configure();
             if(puri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

            given()
                    .when()
                    .get(puri)
                    .then()
                    .assertThat()
                    .body("MRData.CircuitTable.Circuits.circuitId",hasSize(size));
            vrf=true;
        } catch (Exception e) {
            vrf=false;
            FileWriter w = new FileWriter("src/main/TESTRESULT/temp.txt",true);
            BufferedWriter out = new BufferedWriter(w);
            out.newLine();
            out.write("Test date and time is:");
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            // Now format the date
            String date1= dateFormat.format(date);
            // Print the Date
            System.out.println("Test date and time is " +date1+"result is:"+vrf);
            out.write(date1+"result is:"+vrf+"  cause: "+e);
            out.flush();
            out.close();
            System.out.println(e);
        }
return vrf;
    }

    public static int getResponseSizebyUrl(String puri,String jpath)  {
                    org.apache.log4j.BasicConfigurator.configure();

            if(puri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

            Response resp= RestAssured.get(puri);
            int size = resp.jsonPath().getList(jpath).size();
             // .body("MRData.CircuitTable.Circuits.circuitId",hasSize(size));
        return size;
    }

    public static int getResSizebyResponse(Response resp,String jpath) {
        org.apache.log4j.BasicConfigurator.configure();
        int size = resp.jsonPath().getList(jpath).size();
        return size;
    }






}
