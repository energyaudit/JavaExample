package main.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static main.util.ShortStrMonthMap2Month.ShortStrMonthMap2Month;

public class string2Date {
    public static LocalDate string2Date(String stringDate){
        String month=stringDate.contains(" ") ? stringDate.split(" ")[0] :stringDate;
        if( month.length()<4){
            String monthLong=ShortStrMonthMap2Month(month);
            stringDate=stringDate.replace(stringDate.split(" ")[0],monthLong);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(stringDate, formatter);
        System.out.println(date);
        return date;
    }
    public static void main(String[] args) {
        String[] stringTest = {"January 2, 2010","June 24, 2020","Jun 25, 2020","Aug 16, 2020"};
   for( int i=0;i<stringTest.length;i++){
       string2Date(stringTest[i]);
   }
    }
}
