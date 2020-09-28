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
import java.util.HashMap;
import static io.restassured.RestAssured.given;
/**
 * Created by byang on 91/26/2016.
 */

public class PostCode {
    public static boolean vrf;

    public static boolean inputpar(String puri, HashMap map, int pcode) throws IOException {
        try {
        org.apache.log4j.BasicConfigurator.configure();
       if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

            int code=given()
                    .contentType("application/json")
                    .body(map)
                    .when()
                    .post(puri)
                    .statusCode();
        if (code==pcode){vrf=true; } else {vrf = false; }
        } catch (Exception e) {
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
        System.out.println(vrf);
        return vrf;
    }

}
