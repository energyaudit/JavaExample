package main.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class string2Date {
    public static LocalDate string2Date(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(stringDate, formatter);
        System.out.println(date);
        return date;
    }
    public static void main(String[] args) {
        String[] stringTest = {"January 2, 2010","June 24, 2020"};
   for( int i=0;i<stringTest.length;i++){
       string2Date(stringTest[i]);
   }
    }
}
