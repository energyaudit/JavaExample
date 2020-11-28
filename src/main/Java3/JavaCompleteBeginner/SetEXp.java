package main.Java3.JavaCompleteBeginner;


import java.util.*;

import static main.util.JavaUtil.set2LinkedList;

public class SetEXp {

    public static void main(String[] args) {

        // HashSet does not retain order.
        // Set<String> set1 = new HashSet<String>();

        // LinkedHashSet remembers the order you added items in
        // Set<String> set1 = new LinkedHashSet<String>();

        // TreeSet sorts in natural order
        Set<String> set1 = new TreeSet<String>();

        if (set1.isEmpty()) {
            System.out.println("Set is empty at start");
        }

        set1.add("dog");
        set1.add("cat");
        set1.add("mouse");
        set1.add("snake");
        set1.add("bear");

        if (set1.isEmpty()) {
            System.out.println("Set is empty after adding (no!)");
        }

        // Adding duplicate items does nothing.
        set1.add("mouse");

        System.out.println(set1);

        // ///////// Iteration ////////////////

        for (String element : set1) {
            System.out.println(element);
        }

        // ////////// Does set contains a given item? //////////
        if (set1.contains("aardvark")) {
            System.out.println("Contains aardvark");
        }

        if (set1.contains("cat")) {
            System.out.println("Contains cat");
        }
        ///Why doesn't java.util.Set have get(int index)?Because sets have no ordering.
        // If you're trying to use sets this way, you should consider using a list instead.This kind of leads to the question when you should use a set and when you should use a list. Usually, the advice goes:
        //If you need ordered data, use a List
        //If you need unique data, use a Set
        //If you need both, use either: a SortedSet (for data ordered by comparator) or an OrderedSet/UniqueList (for data ordered by insertion).
        // Unfortunately the Java API does not yet have OrderedSet/UniqueList.
        System.out.println("Created LinkedList is");
        List<String> lList = new LinkedList<String>(set1);
        for (String x : lList)
            System.out.println(x);

        /// set2 contains some common elements with set1, and some new

        Set<String> set2 = new TreeSet<String>();

        set2.add("dog");
        set2.add("cat");
        set2.add("giraffe");
        set2.add("monkey");
        set2.add("ant");
        //use function set2Linkedlist to convert set to linked list
        List alist=set2LinkedList(set2);

        ////////////// Intersection ///////////////////

        Set<String> intersection = new HashSet<String>(set1);

        intersection.retainAll(set2);

        System.out.println("intersection of 2 set:    "+intersection);

        Set<String> set11 = new TreeSet<String>();
        if (set11.isEmpty()) {
            System.out.println("Set is empty at start");
        }
        Integer[] array1= { 0 ,  1 , 2 ,  3 ,  4  ,  5 };
        for(int i=0; i<array1.length; i++) {
            set11.add(array1[i].toString());
                  }
        System.out.println(set11);
        Set<String> set22 = new TreeSet<String>();
        Integer[] array2=  {  4 ,  7 , 8 , 9 , 10 , 1 };
        for(int i=0; i<array2.length; i++) {
            set22.add(array2[i].toString());
        }
        System.out.println(set22);
        Set<String> intersection1 = new HashSet<String>(set11);
        System.out.println(intersection1);
        intersection1.retainAll(set22);
        System.out.println("intersection of the set11 and set22 :    "+intersection1);

        ////////////// Difference /////////////////////////

        Set<String> difference = new HashSet<String>(set2);

        difference.removeAll(set1);
        System.out.println(difference);
    }

}