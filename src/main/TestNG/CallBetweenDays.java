package main.TestNG;

import static main.util.DateBetweenDays.betweenDays;

public class CallBetweenDays {
    public static void main(String[] args) {
        String date1 = "2017-05-24";
        String date2 = "2020-05-15";
        betweenDays(date1,date2);
    }
}
