package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class formatDate {
    public static String formatDate(Date date,String format){
              Date dateInput=(date==null?new Date():date) ;  //if input date is null then Getting today's date
        //Printing today's date in the default formatj
        System.out.println("Today is : " + dateInput);
        //Formatting today's date in dd MMMM yyyy format
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        System.out.println("Today in dd MMMM yyyy format : " + formatter.format(dateInput));
        return formatter.format(dateInput);
    }
    public static void main(String[] args) {
        formatDate(null,"dd/MM/yyyyy");
        formatDate(null,"dd MMMM yyyy");
        formatDate(null,"\"yyyy-MM-dd\"");
        formatDate(null,"E, dd MMM yyyy");
        formatDate(null,"dd-MMM-yyyy HH:mm:ss");
        formatDate(null,"EEEE, MMM dd yyyy, hh:mm:ss a");
        formatDate(null,"dd-MMM-yyyy HH:mm:ss Z");
    }
}