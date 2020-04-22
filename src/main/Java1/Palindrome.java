package main.Java1;

import java.util.Scanner;
public class Palindrome {
    static boolean  isPalindrome(String str) {
        String  rev = "";
        int length = str.length();

        for ( int i = length - 1; i >= 0; i-- )
            rev = rev + str.charAt(i);
        if (str.equals(rev))
            return true;
        else
        return false;
    }
    public static void main(String args[])
    {
        String str1 = "ROTOR";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string:");
//        str1 = sc.nextLine();
        boolean Result;
        Result=isPalindrome(str1);
        System.out.println("The string is: "+ Result);
        String[] testStrings = { "kayak", "refer", "mom", "dog", "levels", "no more", "longest", "civic", "madam", "reviver", "reader", "top spot"};
        int length = testStrings.length;
        for ( int i = length - 1; i >= 0; i-- ){
            System.out.println(testStrings[i]+" is: "+ isPalindrome(testStrings[i]));
        }
        Integer[] testNumber={10101,10201,10301,10501,10601,10801};
        int length1 = testNumber.length;
        for ( int i = length1 - 1; i >= 0; i-- ){
            String j=testNumber[i].toString();
            System.out.println(testNumber[i]+" is: "+ isPalindrome(j));
        }
    }
}
