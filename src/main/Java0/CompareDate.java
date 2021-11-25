package src.main.Java0;
/**
*Java Duration class is used to measures time in seconds and nanoseconds. It inherits the Object
 *  class and implements the Comparable interface.
*/

import org.joda.time.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
public class CompareDate {

    public static void main(String[] args) throws ParseException {

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date1 = sdf.parse("2009-12-31");
        //  Date date1 = sdf.parse("31/5/2019");

       Date date2 = sdf.parse("2010-01-31");
        //    Date date2 = sdf.parse("29/3/2019");


        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        Interval interval = new Interval(date1.getTime(), date2.getTime());
        org.joda.time.Duration period = interval.toDuration();
        long Diff=period.getStandardDays();
        System.out.println(Diff);

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        if (cal1.after(cal2)) {
            System.out.println("Date1 is after Date2");
        }

        if (cal1.before(cal2)) {
            System.out.println("Date1 is before Date2");
        }

        if (cal1.equals(cal2)) {
            System.out.println("Date1 is equal Date2");
        }


        //Duration example2:
        Duration d = Duration.between(LocalTime.NOON,LocalTime.MAX);
        System.out.println(d.get(ChronoUnit.SECONDS));
    }

}