package main.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonStr2JsonFile {
    public static void inputStr(String JsonStr, String filepath) {
        try {
            FileWriter w = new FileWriter(filepath);
            BufferedWriter out = new BufferedWriter(w);
            out.newLine();
            out.write(JsonStr);
            out.newLine();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }

    }
}
