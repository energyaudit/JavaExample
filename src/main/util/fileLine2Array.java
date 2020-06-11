package main.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileLine2Array {
    public static ArrayList fileLine2Array(String filepath) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
            System.out.println(result);
        }
        return result;
    }
    public static void main(String args[])throws IOException {
       String filepath="./src/main/TESTRESULT/TestResultl.txt";
        fileLine2Array(filepath);
    }
}
