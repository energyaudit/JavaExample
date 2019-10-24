package src.main.Java2;


import java.net.URL;
        import java.lang.*;
public class getResource1  {
    public static void main(String[] args) throws Exception {
        getResource1  obj = new getResource1 ();
        Class class1 = obj.getClass();
        URL url = class1.getResource("DataBase1.java");
        System.out.println("Value URL = " + url);
        url = class1.getResource("newfolder/file2.txt");
        System.out.println("Value URL = " + url);
    }
}