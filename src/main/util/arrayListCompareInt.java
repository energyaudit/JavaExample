package main.util;

import java.util.ArrayList;
import java.util.Collections;

public class arrayListCompareInt {

    public static Boolean arrayListCompareANInt(ArrayList<String> listStr, String operator, Integer benchmark) {
        Boolean compare = false;
        switch (operator) {
            case "<=":
                ArrayList<Integer> listInt = new ArrayList<Integer>();
                for (String str : listStr) {
                    listInt.add(Integer.parseInt(str));
                }
                System.out.println("max in list is :" + Collections.max(listInt));
                if (Collections.max(listInt) <= benchmark) {
                    compare = true;

                }
                break;
            case ">=":
                ArrayList<Integer> listInt1 = new ArrayList<Integer>();
                for (String str1 : listStr) {
                    listInt1.add(Integer.parseInt(str1));
                }
                if (Collections.max(listInt1) >= benchmark) {
                    compare = true;
                }
                break;
            case "=":
                for (String str2 : listStr) {
                    if (Integer.parseInt(str2) < benchmark || Integer.parseInt(str2) > benchmark) {
                        compare = false;
                    } else {
                        compare = true;
                    }
                    break;
                }
            }
        System.out.println("The whole arraylist" + listStr + operator + benchmark + " :  " + compare);
        return compare;
    }
    public static void main(String[] args) {
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("9");
        listStr.add("8");
        listStr.add("9");
        listStr.add("8");
        listStr.add("7");
        listStr.add("8");
        arrayListCompareANInt(listStr,">=",8);
        arrayListCompareANInt(listStr,">=",9);
        arrayListCompareANInt(listStr,">=",10);
        arrayListCompareANInt(listStr,"<=",10);
        arrayListCompareANInt(listStr,"<=",9);
        arrayListCompareANInt(listStr,"<=",6);
        arrayListCompareANInt(listStr,"<=",0);
        ArrayList<String> listStr1 = new ArrayList<>();
        listStr1.add("8");
        listStr1.add("8");
        listStr1.add("8");
        arrayListCompareANInt(listStr1,"=",8);
    }

}
