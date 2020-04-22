package main.Java1;

import java.util.Scanner;

public class Palindrome {
    static boolean  isPalindrome(String str) {
        String  rev = "";
        int length = str.length();

        for ( int i = length - 1; i >= 0; i-- )
            rev = rev + str.charAt(i);

        if (str.equals(rev))
//            System.out.println(str+" is a palindrome");
            return true;
        else
//            System.out.println(str+" is not a palindrome");
        return false;
    }
    public static void main(String args[])
    {
        String str1 = "ROTOR";
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter a string:");
//        str1 = sc.nextLine();
        boolean Result;
        Result=isPalindrome(str1);
        System.out.println("The string is: "+ Result);
    }




}
