package main.TestNG;

import static main.util.CountWords.arrayElementCount;
import static main.util.CountWords.countWordRepat;

public class callCountWordArrayEleRepat {
    public static void main(String[] args) {
        String strIn = "This this is is done by Saket Saket";
        countWordRepat(strIn);
        //count elements in array by call method  arrayElementCount
        arrayElementCount(new int[]{4, 5, 4, 5, 4, 6});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{12, 9, 12, 9, 10, 9, 10, 11});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{891, 187, 891, 187, 891, 476, 555, 741});
    }
}
