package main.util;

import java.util.Calendar;

public class parseDateNow2String {
    public static String parseDateNow2String (){
        String Currentdate;
        Calendar now = Calendar.getInstance();
        if ((now.get(Calendar.MONTH) < 10)) {
             Currentdate = now.get(Calendar.YEAR) + "-0" + (now.get(Calendar.MONTH) + 1)
                    + "-" + now.get(Calendar.DATE);
        } else {
         Currentdate = now.get(Calendar.YEAR) + "-0" + (now.get(Calendar.MONTH) + 1)
                    + "-" + now.get(Calendar.DATE);
        }
        return Currentdate;
    }
    public static void main(String[] args) {
   System.out.println(parseDateNow2String ());
    }

}
