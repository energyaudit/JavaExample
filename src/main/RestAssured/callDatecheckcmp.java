package main.RestAssured;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static main.util.CompaDifferFormatDate.datecheckcmp;

public class callDatecheckcmp {
    public static void main(String args[]) throws ParseException {
        Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        System.out.println("Today : " + today);

//        CompaDifferFormatDate obj = new CompaDifferFormatDate();
        String str = datecheckcmp("dd/MM/yyyy", "dd/MM/yyyy", "27/12/2018", today);
           System.out.println(str);
    }
}
