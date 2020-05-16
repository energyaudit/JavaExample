package main.TestNG;

import static main.util.removeSpecifyChar.removeSpecificChars;

public class CallRemoveSpeicalChar {
    public static void main(String[] args)
    {
        String originalstring="Alive is Awesome";
        System.out.println("Original string is >>  "+ originalstring);

        String removecharacterstring="asmz";
        String output=removeSpecificChars(originalstring, removecharacterstring);
        System.out.println("");
        System.out.println("");
        System.out.print("Output is >>  " );
        System.out.println(output);
    }
}
