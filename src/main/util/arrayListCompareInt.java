package main.util;

import java.util.ArrayList;

public class arrayListCompareInt {

    public static Boolean arrayListCompareANInt(ArrayList<String> listStr, String operator, Integer benchmark) {
        Boolean compare = true;
        switch (operator) {
            case "<":
                for (String str : listStr) {
                    if (Integer.parseInt(str) >= benchmark) {
                        compare = false;
                        break;
                    }
                }

            case ">":
                for (String str1 : listStr) {

                    if (Integer.parseInt(str1) <= benchmark) {
                        System.out.println(Integer.parseInt(str1));
                        compare = false;
                        break;
                    }

                }
            case "=":
                for (String str1 : listStr) {
                    if (Integer.parseInt(str1) < benchmark||Integer.parseInt(str1) > benchmark) {
                        compare = false;
                    }
                    break;
                }
        }
        System.out.println("The whole arraylist"+listStr+operator+benchmark+" :  "+compare);
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
//        arrayListCompareANInt(listStr,"<",8);
        arrayListCompareANInt(listStr,">",5);
        arrayListCompareANInt(listStr,">",0);
        ArrayList<String> listStr1 = new ArrayList<>();
        listStr1.add("8");
        listStr1.add("8");
        listStr1.add("8");
        arrayListCompareANInt(listStr1,"=",8);
    }

}
