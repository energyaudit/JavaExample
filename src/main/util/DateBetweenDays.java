package main.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DateBetweenDays {
    public static long betweenDays(String dateBeforeString, String dateAfterString){
        LocalDate localDate = LocalDate.now();
        System.out.println("Today is:  "+localDate.toString());                //2013-05-15
        System.out.println("day of week today is:   "+localDate.getDayOfWeek().toString()); //WEDNESDAY
        System.out.println(localDate.getDayOfMonth());           //15
        System.out.println(localDate.getDayOfYear());            //135
        System.out.println("is this year leap year?"+localDate.isLeapYear());              //false
        System.out.println("what is 12 days later of doady?   "+localDate.plusDays(12).toString());   //2013-05-27


        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(dateBeforeString);
        LocalDate dateAfter = LocalDate.parse(dateAfterString);

        //calculating number of days in between
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        //displaying the number of days
        System.out.println(noOfDaysBetween);
        return noOfDaysBetween;
    }
    public static void main(String[] args) {
        String date1 = "2017-05-24";
        String date2 = "2020-05-15";
        System.out.println("days between these 2 date are:  "+betweenDays(date1,date2));
    }
}
