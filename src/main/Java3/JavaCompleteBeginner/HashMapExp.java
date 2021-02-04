package main.Java3.JavaCompleteBeginner;


import main.util.JavaUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapExp {


    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(5, "Five");
        map.put(8, "Eight");
        map.put(6, "Six");
        map.put(4, "Four");
        map.put(2, "Two");

        String text = map.get(6);

        System.out.println(text);

        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + ": " + value);
        }

        ////////////////////map contains key
       Map<String,String> mini=new LinkedHashMap<>();
        mini.put("5", "Five");
        mini.put("8", "Eight");
        mini.put("6", "Six");
        mini.put("4", "Four");
        mini.put("2", "Two");
        JavaUtil jul=new JavaUtil();
        boolean present=jul.mapContainKey(mini,"5");
        boolean presentValue=jul.mapContainValue(mini,"Five");






    }

}