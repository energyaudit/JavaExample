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


public class RTime {
    public static boolean vrf;

    public static long inputpar(String puri) throws IOException {

//        try {
        org.apache.log4j.BasicConfigurator.configure();
        if(puri.toLowerCase().contains("https")) { RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()); }

        Response resp= RestAssured.get(puri);
        String data=resp.asString();
        System.out.println(data);
        String jsonString=data;
        long RespTime=resp.getTime();
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        try {
            //   FileWriter writer = new FileWriter("/QA/TESTRESULT/temp.json");
             FileWriter writer = new FileWriter("src/main/TESTRESULT/temp.json");
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
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
            out.write(date1+"result is:"+"  cause: "+e);
            out.flush();
            out.close();
            System.out.println(e);
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Response time:"+resp.getTime());
              return RespTime;
    }

}
