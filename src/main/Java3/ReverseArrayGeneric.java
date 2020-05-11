package main.Java3;
import java.util.*;
public class ReverseArrayGeneric
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // Given input array
        Integer[] inputArray = {3,7,9,6,4};
        String[] inputArray1={"now"," original", "string"," is ","changed"};
        // Print array before reverse
        System.out.println("Array without reverse" +
                Arrays.toString(inputArray));
        // Calling method to swap elements
        System.out.println("Array without reverse" +
                Arrays.toString(inputArray1));
        reverseArray(inputArray1);
    }
    public static<T> void reverseArray(T[] inputArray) {

        for (int left = 0, right = inputArray.length - 1;
             left < right; left++, right--) {
            // swap the values at the left and right indices
           T temp = inputArray[left];
            inputArray[left]  = inputArray[right];
            inputArray[right] = temp;
        }
        // Printing the Array after reverse
        System.out.print("Reverse Array :");
        for(T val : inputArray)
            System.out.print(" "+val);
    }
}

