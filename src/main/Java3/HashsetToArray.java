package main.Java3;

import java.util.*;

public class HashsetToArray {
    public static void main(String args[]) {
        HashSet<String> hashset = new HashSet<String>();
        // Add elements to HashSet
        hashset.add("Pear");
        hashset.add("Apple");
        hashset.add("Orange");
        hashset.add("Papaya");
        hashset.add("Banana");
        System.out.println("HashSet contains :" + hashset);        //Showing HashSet elements
        // Creating an Array of HashSet size
        String[] array = new String[hashset.size()];
        // Converting HashSet to Array using toArray() method
        hashset.toArray(array);
        System.out.println("Array contains :");        //Showing Array elements
        for(String str : array){
            System.out.println(str);
        }
    }
}