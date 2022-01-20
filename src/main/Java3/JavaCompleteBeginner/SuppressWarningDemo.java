package main.Java3.JavaCompleteBeginner;


import java.io.*;
        import java.lang.*;
        import java.util.*;

// Class 1
// Helper class
class Addition {

    // Method 1
    public static int sum(int n1, int n2)
    {

        // Return the final sum
        return n1 + n2;
    }

    // Method 2
    public static int sum(int... nums)
    {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        // Return the final sum
        return sum;
    }
}

// Class 2
// Main class
// To test suppress warnings
public class SuppressWarningDemo {

    // Does not check if data type is Object or primitive
    @SuppressWarnings("unchecked")

    // Main driver method
    public static void main(String[] args)
    {

        // Creating an object of above class in main()
        // method
        Addition add = new Addition();

        // Ignore when we're using a deprecated
        // (no longer important) method or type
        @SuppressWarnings("deprecation")

        int sum = Addition.sum(10, 20);

        // Print and display the sum
        System.out.println("Sum of 10 and 20 : " + sum);

        @SuppressWarnings("rawtypes")

        // Raw data type being used instead of generic
        List list = new ArrayList();

        // Custom input entries
        list.add(12);
        list.add(120);

        // Print and display List elements
        System.out.println("List items : " + list);
    }
}