package main.util;

import java.util.*;

/**
 * Created by byang on 2018-11-29.
 */

public class sortLinkedHashMapByValue {
    //converted the hash map to a list capitalList. Then, we use sort() method which takes a list and a comparator.ascending
    public static LinkedHashMap<String, String> sortLinkedHashMap(LinkedHashMap<String, String> map) {
        List<Map.Entry<String, String>> capitalList = new LinkedList<>(map.entrySet());
//comparator is the lambda which compares (o1, o2) -> o1.getValue().compareTo(o2.getValue()) two values of the items in the list o1 and o2.
        Collections.sort(capitalList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//convert the list to LinkedHashMap result and return it.
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : capitalList)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {

        LinkedHashMap<String, String> capitals = new LinkedHashMap<>();
        capitals.put("Nepal", "Kathmandu");
        capitals.put("India", "New Delhi");
        capitals.put("United States", "Washington");
        capitals.put("England", "London");
        capitals.put("Australia", "Canberra");
        Map<String, String> result = sortLinkedHashMap(capitals);
        for (Map.Entry<String, String> entry : result.entrySet())
        {
            System.out.print("Key: " + entry.getKey());
            System.out.println(" Value: " + entry.getValue());
        }
    }

}
