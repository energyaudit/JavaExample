package src.main.Java3;

import java.util.HashMap;

/**
 * Created by byang on 2018-11-22.
 *  * */
public class FirstNonRepeat {
    public static void main(String[] args) {
        String str1 = "google";
        System.out.println("Index of first non-repeating character in '" + str1 + "' is: " + first_unique_character(str1)+"it is:  "+ str1.charAt( first_unique_character(str1)) );
        String[] testStr={"google","teeter"};
        for (int i = 0; i < testStr.length; i++) {
            System.out.println(testStr[i]);
            System.out.println("Index of first non-repeating character in '" + str1 + "' is: " + first_unique_character(testStr[i])+"it is:  "+ first_unique_character(testStr[i]));
//            first_unique_character(testStr[i]);
        }
    }

    public static int first_unique_character(String str1) {
        HashMap< Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < str1.length(); ++i) {
            char chr = str1.charAt(i);
            map.put(chr, map.containsKey(chr) ? map.get(chr) + 1 : 1);//if already containsKey(chr) then its value+1, char is key,integer is value.if not contains means different so
        }
        for (int i = 0; i < str1.length(); ++i) {
            if (map.get(str1.charAt(i)) < 2) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * Pseudo Algorithm
 *
 * 1.   First create the  character count hash table .
 *
 *           For each character
 *             If there is no value stored in the character
 *                      set it to 1 .
 *             else
 *                      increment the value of the character by 1 .
 *
 * 2.  Scan the string
 *            For each character
 *            return character if the count in hash table is 1 .
 *            If no character have count 1 , return null
 * * */