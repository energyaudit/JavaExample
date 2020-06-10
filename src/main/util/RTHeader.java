package main.util;

import io.restassured.config.SSLConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class RTHeader {
    public static boolean vrf;

    public static boolean inputpar(String puri,String size) throws IOException {

        try {
            org.apache.log4j.BasicConfigurator.configure();
       //     String uri="http://ergast.com/api/f1/2017/circuits.json";
            if(puri.toLowerCase().contains("https")) { config = config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

            given()
                    .when()
                    .get(puri)
                    .then()
                    .assertThat()
                    .header("Content-Length",equalTo(size));
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
            System.out.println("Test date and time is " +date1+e);
            out.write(date1);
            out.flush();
            out.close();
            System.out.println(e);
        }
return vrf;
    }

}
