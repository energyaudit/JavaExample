package main.Java3.JavaCompleteBeginner;
/**
 * Differences between TreeMap, HashMap and LinkedHashMap in Java,HashMap offers 0(1) lookup and insertion.
 * If you iterate through the keys, though, the ordering of the keys is essentially arbitrary.LinkedHashMap
 * offers 0(1) lookup and insertion. Keys are ordered by their insertion order.TreeMap offers O(log N) lookup
 * and insertion. Keys are ordered, so if you need to iterate through the keys in sorted order
 */

import java.util.Map;
import java.util.TreeMap;

public class SortedMap {

    public static void main(String[] args) {

        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
//if sort map by key, then just use tree map will do
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(9, "fox");
        map.put(4, "cat");
        map.put(8, "dog");
        map.put(1, "giraffe");
        map.put(0, "swan");
        map.put(15, "bear");
        map.put(6, "snake");

        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + ": " + value);
        }
    }

}
