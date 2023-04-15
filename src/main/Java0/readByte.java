package main.Java0;


import java.io.UnsupportedEncodingException;
import java.util.*;

// Main class
// GetByte
public class readByte  {

    // Main driver method
    public static void main(String args[]) throws UnsupportedEncodingException {

        // Declaring and initializing a string
        String gfg = "Geeks for Geeks";

        // Displaying string values before conversion
        System.out.println(
                "The String before conversion is : ");
        System.out.println(gfg);

        // Converting the string into byte
        // using getBytes() method
        byte[] b = gfg.getBytes();

        // Display message only
        System.out.println(
                "The String after conversion is : ");

        // Printing converted string after conversion
        for (int i = 0; i < b.length; i++) {

            System.out.print(b[i]);
        }

        byte[] butf = gfg.getBytes("UTF-16");

        // Displaying converted string
        // after conversion into UTF-16
        System.out.println(
                "The String after conversion into UTF-16 is : ");

        // Iterating over the string
        for (int i = 0; i < butf.length; i++) {
            System.out.print(butf[i]);
        }

        System.out.print("\n");

        // Converting the above string into byte
        // using getBytes() method
        byte[] c = gfg.getBytes("UTF-16BE");

        // Displaying converted string
        // after conversion into UTF-16BE
        System.out.println(
                "The String after conversion into UTF-16BE is : ");

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }




    }
}