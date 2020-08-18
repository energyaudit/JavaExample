package main.util;

import java.io.*;

public class ConvertIntoSnakeCase
{

    // Function to replace
// spaces and convert
// into snake case
    static void convertIntoSnakeCase(String str)
    {
        int n = str.length();
        String str1 = "";

        for (int i = 0; i < n; i++)
        {
            // Converting space
            // to underscor
            if (str.charAt(i) == ' ')
                str1 = str1 + '_';
            else

                // If not space, convert
                // into lower character
                str1 = str1 +
                        Character.toLowerCase(str.charAt(i));
        }

        System.out.print(str1);
    }

    // Driver Code
    public static void main(String args[])
    {
        String str = "I got intern at google!";

        // Calling function
        convertIntoSnakeCase(str);
    }
}