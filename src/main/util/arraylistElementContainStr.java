package main.util;


import java.util.ArrayList;
import java.util.List;

public class arraylistElementContainStr {
    public static Boolean arraylistEleContainInputStr(List<String> aList, String str) {
        Boolean found = false;
        for (String s : aList) {
            if (s.contains(str)) {
                System.out.println("The element " + str + " is available in the ArrayList");
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("The element " + str + " is not available in the ArrayList");
        }
        return found;
    }

    public static void main(String[] args) {
        List aList = new ArrayList();
        aList.add("A");
        aList.add("B");
        aList.add("C");
        aList.add("D");
        aList.add("East Gwillimbury");
        Boolean exist = arraylistEleContainInputStr(aList, "Gwillimbury");
        System.out.println(exist);
        if (aList.contains("H"))
            System.out.println("The element H is available in the ArrayList");
        else
            System.out.println("The element H is not available in the ArrayList");
    }
}