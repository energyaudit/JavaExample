package main.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static main.util.ReverseArrayGeneric.reverseArray;
import static main.util.arraylistToArray.ArrayListToArray;

public class reverseLinkedList2Array {
    public static String[] reverseLinkedListToArray(LinkedList linkedlistin){
        // Converting LinkedList to ArrayList
        List<String> list = new ArrayList<String>(linkedlistin);

        for (String str : list){
            System.out.println(str);
        }
        String[] array=ArrayListToArray(list);
        reverseArray(array);
        return array;
    }
    public static void main(String args[]) {
        // Creating LinkedList Object
        LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.add("Mango");
        linkedlist.add("Banana");
        linkedlist.add("Pear");
        linkedlist.add("Apple");
        linkedlist.add("Orange");
        reverseLinkedListToArray(linkedlist);
    }
}
