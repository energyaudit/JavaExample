package main.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;

public class JavaUtil {
    public ArrayList<String> ArrayListStrDescendingSort(ArrayList<String> arrayList) {
        System.out.println("ArrayList Before Sorting:");
        for(String str: arrayList){
            System.out.println(str);
        }
        /* Sorting in decreasing (descending) order*/
        Collections.sort(arrayList, Collections.reverseOrder());
         System.out.println("ArrayList in descending order:");
        for(String str: arrayList){
            System.out.println(str);
        }
        return arrayList;
    }

}
