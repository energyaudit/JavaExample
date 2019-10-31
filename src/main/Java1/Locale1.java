package main.Java1;


import java.util.*;
public class Locale1
{
    public static void main(String[] args)
    {
        // Creting a new Locale
        Locale geek1 = new Locale("English", "CA");

        // Use of getDefault() :
        Locale geek2 = Locale.getDefault();

        System.out.println("Locale name : " + geek1);
        System.out.println("Locale name Default : " + geek2);

        // Use of getDisplayCountry() :
        System.out.println("\nCountry Name : "
                + geek1.getDisplayCountry());

        // Use of getCountry() :
        System.out.println("Country Name ISO 3166 2-letter code : "
                + geek1.getCountry());

        // Use of equal() :
        System.out.println("\nIs geek1 equals geek2 : "
                + geek1.equals(geek2));

        // clone() : geek3 is a clone of geek2
        Locale geek3 = (Locale) geek2.clone();

        // Locale : geek3
        System.out.println("Locale geek3 same as geek2 : "
                + geek3);

        // Use of getAvailableLocales()
        Locale[] geek4 = Locale.getAvailableLocales();

        // We are not printing all the locales.
        System.out.println("\nInstalled locales are : ");
        for (int i = 1; i < geek4.length/10; i++)
            System.out.println(i + ":" + geek4[i]);

        // Use of getDisplayLanguage() :
        System.out.println("\ngeek2 Language : "
                + geek2.getDisplayLanguage());

        // Use of getDisplayLanguage(Locale in) :
        System.out.println("Language of in Locale : "
                + geek1.getDisplayLanguage(new Locale("France", "French")));

        // Use of getDisplayName :
        System.out.println("\nUse of getDisplayName : "
                + geek1.getDisplayName());

        // Use of getDisplayName(Locale in) :
        System.out.println("Name of in Locale : "
                + geek2.getDisplayName(new Locale("English", "english")));

        // Use of getISO3Country() :
        System.out.println("\nISO3 Country Name of geek3 : "
                + geek3.getISO3Country());

    }
}