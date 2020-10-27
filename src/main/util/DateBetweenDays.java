package main.util;
/**
 * Created by byang on 2/20/2018.
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import static main.util.parseDateNow2String.parseDateNow2String;

public class DateBetweenDays {
    public static long betweenDays(String dateBeforeString, String dateAfterString){
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
        System.out.println("days between now and date are:  "+betweenDays(date2,parseDateNow2String ()));

    }
}
