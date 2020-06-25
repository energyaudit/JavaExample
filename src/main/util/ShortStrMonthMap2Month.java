package main.util;

import main.Java3.JavaCompleteBeginner.AnimalEnum;

public class ShortStrMonthMap2Month {
    public static String ShortStrMonthMap2Month(String shortMon){
       String shortMonth=shortMon.toLowerCase();
        switch (shortMonth) {
            case "jan":
                return "January";

            case "feb":
                return "February";

            case "mar":
                return "March";

            case "apr":
                return "April";

            case "may":
                return "May";

            case "jun":
                return "June";

            case "jul":
                return "July";

            case "aug":
                return "August";

            case "sep":
                return "September";

            case "oct":
                return "October";

            case "nov":
                return "November";

            case "dec":
                return "December";

            default:
                return "you have not enter a valid month";

        }
    }
    public static void main(String[] args) {
     String[] test={"Jan","FEB","MAr","aPr","MAY","JUn","juL","Aug","SEP","OCT","nov","DEC"};
     for (int i=0;i<test.length;i++){
         System.out.println(ShortStrMonthMap2Month(test[i]));
     }
       String str="Jun 24, 2020";
       String month=str.contains(" ") ? str.split(" ")[0] : str;
//        str is having empty value it returns as it is.
//        str is having one word, it returns as it is.
//        str is multiple words, it extract the first word and return.
        String monthLong=ShortStrMonthMap2Month(month);
        System.out.println(ShortStrMonthMap2Month(month));
        String fin=str.replace(str.split(" ")[0],monthLong);
        System.out.println(fin);
    }
}
