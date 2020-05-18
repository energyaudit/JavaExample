package main.TestNG;

import java.util.HashMap;

import static main.util.CountWords.arrayElementCount;

public class callCountWords {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "This this is is done by Saket Saket";
        String[] split = str.split(" ");
        HashMap<String, Integer> map = new HashMap<String, Integer>();//key type String, Value Integer
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                int count = map.get(split[i]);//this word count+1
                map.put(split[i], count + 1);
            } else {
                map.put(split[i], 1);
            }
        }//there is a bug that last one
        System.out.println(map);
        //count elements in array by call method  arrayElementCount
        arrayElementCount(new int[]{4, 5, 4, 5, 4, 6});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{12, 9, 12, 9, 10, 9, 10, 11});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{891, 187, 891, 187, 891, 476, 555, 741});
    }
}
