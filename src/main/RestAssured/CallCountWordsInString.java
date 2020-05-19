package main.RestAssured;

import main.util.CountTotalWordsInString;

public class CallCountWordsInString {
    public static void main (String args[])
    {
       int res= CountTotalWordsInString.wordcount("   manchester united is also known as red devil ");
        //string is always passed in double quotes

        System.out.println("The number of words in the String are :  "+res);
    }
}
