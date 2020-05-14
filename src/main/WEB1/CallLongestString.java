package main.WEB1;

import java.util.Arrays;

import static main.WEB1.util.LongestString.longestWords;

public class CallLongestString {
    public static void main(String[] args) {
        String [] dict = {"cat", "flag", "green", "country", "w3resource"};
        //  String [] dict = {"cat", "dog", "red", "is", "am"};
        System.out.println("Original dictionary : "+ Arrays.toString(dict));
        System.out.println("Longest word(s) of the above dictionary: "+longestWords(dict));
    }
}
