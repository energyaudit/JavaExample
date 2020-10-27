package main.Java3;
/**
 * Created by byang on 2/20/2018.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import main.util.DateBetweenDays;
import main.util.dateFormatConvert;

public class callBetweenDaysbyFormat {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Today is:  "+localDate.toString());                //2013-05-15
        System.out.println("day of week today is:   "+localDate.getDayOfWeek().toString()); //WEDNESDAY
        System.out.println(localDate.getDayOfMonth());           //15
        System.out.println(localDate.getDayOfYear());            //135
        System.out.println("is this year leap year?"+localDate.isLeapYear());              //false
        System.out.println("what is 12 days later of doady?   "+localDate.plusDays(12).toString());   //2013-05-27

        dateFormatConvert dfc= new dateFormatConvert();

        String date3 = "2020-06-25";
        String date4 = "9/8/2020";
       String fromFormat="MM/dd/yyyy";
        String toFormat = "yyyy-MM-dd";
String date4format=dfc.convertDateFormat(fromFormat,toFormat,date4);
System.out.println("After format date: "+date4format);
        DateBetweenDays dbed=new DateBetweenDays();
        try {
            System.out.println("days between these 2 date are:  "+dbed.betweenDays(date3,date4format));
        } catch (Exception e) {
            e.printStackTrace();
        }


        String date1 = "03-16-2020";
        String fromFormat1="MM-dd-yyyy";

        String date1format=dfc.convertDateFormat(fromFormat1,toFormat,date1);
//        String date2 = "9/16/2020";
                String date2 = "9/8/2020";
//        String date2 = "1/16/2020";
        String fromFormat2="MM/dd/yyyy";

        String date2format=dfc.convertDateFormat(fromFormat2,toFormat,date2);
        System.out.println("After format date: "+date2format);

        try {
            System.out.println("days between these 2 date are:  "+dbed.betweenDays(date1format,date2format));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
