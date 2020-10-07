package main.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static main.util.ReverseArrayGeneric.reverseArray;
import static main.util.arraylistToArray.ArrayListToArray;

public class linkedlist2ArraylistTypeStr {
    public static List<String> linkedlist2ArraylistStr(LinkedList linkedlistin){
        // Converting LinkedList to ArrayList
        List<String> list = new ArrayList<String>(linkedlistin);

        for (String str : list){
            System.out.println(str);
        }
               return list;
    }
    public static void main(String args[]) {
        // Creating LinkedList Object
        LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.add("Mango");
        linkedlist.add("Banana");
        linkedlist.add("Pear");
        linkedlist.add("Apple");
        linkedlist.add("Orange");
        List<String> arraylist = linkedlist2ArraylistStr(linkedlist);
        System.out.println(arraylist);
    }
}
