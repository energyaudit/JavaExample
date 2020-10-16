package main.util;

import java.util.Collections;
import java.util.LinkedList;

public class reverseLinkedList2 {

        public static void main(String[] args)
        {
            // Declaring linkedlist without any initial size
            LinkedList<Integer> linkedli = new LinkedList<Integer>();
            // Appending elements at the end of the list
            linkedli.add(1);
            linkedli.add(2);
            linkedli.add(3);
            linkedli.add(4);
            linkedli.add(5);
            System.out.print("Elements before reversing: " + linkedli);
            // Collections.reverse method takes a list as a
            // parameter and returns the reversed list
            Collections.reverse(linkedli);
            System.out.print("\nElements after reversing: " + linkedli);

            LinkedList<String> linkedliStr = new LinkedList<String>();
            // Appending elements at the end of the list
            linkedliStr.add("Apple");
            linkedliStr.add("Banana");
            linkedliStr.add("Pear");
            linkedliStr.add("WaterMelon");
            linkedliStr.add("Mango");
            System.out.print("\nElements before reversing: " + linkedliStr);
            // Collections.reverse method takes a list as a
            // parameter and returns the reversed list
            Collections.reverse(linkedliStr);
            System.out.print("\nElements after reversing: " + linkedliStr);
            Collections.sort(linkedliStr, Collections.reverseOrder());//descending
            System.out.print("\nElements after reverseOrder(): " + linkedliStr);
        }
    }

