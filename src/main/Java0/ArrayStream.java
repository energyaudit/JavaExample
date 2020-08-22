package main.Java0;

/*
The stream(T[] array) method of Arrays class in Java, is used to get a Sequential Stream from the array passed as the parameter
with its elements. It returns a sequential Stream with the elements of the array
 */

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStream {
    public static void main(String[] args)
    {

        // Creating a String array
        String[] arr = { "Geeks", "for", "Geeks",
                "A", "Computer", "Portal" };

        // Using Arrays.stream() to convert
        // array into Stream
        Stream<String> stream = Arrays.stream(arr, 3, 6);

        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
    }
}
