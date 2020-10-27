package main.util;
/**
 * Created by byang on 2/20/2018.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static main.util.parseDateNow2String.parseDateNow2String;

public class dateFormatConvert {
    public static String convertDateFormat(String fromDateFormat, String toDateFormat,
    String date) {
        SimpleDateFormat format1 = new SimpleDateFormat(fromDateFormat);
        SimpleDateFormat format2 = new SimpleDateFormat(toDateFormat);
        Date dateParse = null;
        try {
            dateParse = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convert=format2.format(dateParse);
System.out.println(convert);
    return convert;
    }

    public static void main(String[] args) {
    String srcDate="2013-02-21";
        convertDateFormat("yyyy-MM-dd","dd-MM-yyyy",srcDate);
        convertDateFormat("yyyy-MM-dd","dd/MM/yyyy",srcDate);
        //9/7/2020
        String srcDate1="03-16-2020";
        convertDateFormat("MM-dd-yyyy","dd/MM/yyyy",srcDate1);
        convertDateFormat("MM-dd-yyyy","MM/dd/yyyy",srcDate1);
    }
}
