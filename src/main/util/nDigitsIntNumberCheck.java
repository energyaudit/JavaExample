package main.util;

import java.util.regex.Pattern;

public class nDigitsIntNumberCheck {
    public static boolean ndigitsNumCheck(String strin,Integer digits){
        Pattern digitPattern = Pattern.compile("\\d{"+digits+"}");
        return digitPattern.matcher(strin).matches();
    }

    public static void main(String args[]) {

        // Regular expression in java to check if String is 6 digit number or not
        String [] numbers = {"123", "1234" , "123.12", "abcd123", "123456"};
        Pattern digitPattern = Pattern.compile("\\d{6}");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");

        for(String number: numbers){
            System.out.println( "does " + number + " is 6 digit number : "
                    +ndigitsNumCheck(number,6) );
        }
    }



}
