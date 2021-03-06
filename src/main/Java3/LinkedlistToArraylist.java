package main.Java3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static main.util.ReverseArrayGeneric.reverseArray;
import static main.util.arraylistToArray.ArrayListToArray;

public class LinkedlistToArraylist {
    public static void main(String args[]) {
        // Creating LinkedList Object
        LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.add("Mango");
        linkedlist.add("Banana");
        linkedlist.add("Pear");
        linkedlist.add("Apple");
        linkedlist.add("Orange");
        // Converting LinkedList to ArrayList
        List<String> list = new ArrayList<String>(linkedlist);

        for (String str : list){
            System.out.println(str);
        }
        String[] array=ArrayListToArray(list);
        reverseArray(array);
    }
}
