package main.Java3;


import java.util.*;

public class HashSettoArrayListEx {
    public static void main(String args[]) {
        // Declaring a HashSet
        HashSet<String> hashset = new HashSet<String>();
        // Add elements to HashSet
        hashset.add("Pear");
        hashset.add("Apple");
        hashset.add("Orange");
        hashset.add("Papaya");
        hashset.add("Banana");
        //Showing HashSet elements
        System.out.println("HashSet contains :" + hashset);
        // Creating a List of HashSet elements
        List<String> list = new ArrayList<String>(hashset);
        //Showing TreeSet elements
        System.out.println("ArrayList contains :");
        for (String str : list) {
            System.out.println(str);
        }
    }
}