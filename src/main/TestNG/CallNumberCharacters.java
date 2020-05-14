package main.TestNG;



import static main.util.NumberCharacters.charcount;

public class CallNumberCharacters {
    public static void main (String args[])
    {
      int  res=charcount(" manchester united is also known as red devil ");
        //string is always passed in double quotes

        System.out.println("The number of characters in the String are :  "+res);
    }
}
