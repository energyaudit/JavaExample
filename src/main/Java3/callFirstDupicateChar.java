package main.Java3;

import static main.WEB1.util.firstRepeatDuplicateChar.firstRepeating;

public class callFirstDupicateChar {
    public static void main (String[] args)
    {
        String str = "geeks is good";
        char[] arr = str.toCharArray();
        System.out.println(firstRepeating(arr));
    }
}
