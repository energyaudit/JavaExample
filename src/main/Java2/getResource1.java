package src.main.Java2;


import java.net.URL;
import java.lang.*;

public class getResource1 {
    public static void main(String[] args) throws Exception {
        getResource1 obj = new getResource1();
        Class class1 = obj.getClass();
        URL url = class1.getResource("getResource1.java");//source file  not have class path
        System.out.println("Value URL = " + url);
     //   URL url2 = class1.getResource("temp.json");
        URL url2 = class1.getResource("main/TESTRESULT/member.txt"); //src/main/TESTRESULT/member.txt
        System.out.println("Value URL = " + url2);
    }
}