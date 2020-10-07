package main.util;


import java.util.ArrayList;
        import java.util.List;
public class arraylistContainStrEle {
    public static Boolean arraylistContainStr(List aList,String str){
        if(aList.contains(str)){
            System.out.println("The element " +str+ " is available in the ArrayList");
        return true;
        }
        else{
            System.out.println("The element " +str+" is not available in the ArrayList");
        return false;
        }
    }

    public static void main(String[] args) {
        List aList = new ArrayList();
        aList.add("A");
        aList.add("B");
        aList.add("C");
        aList.add("D");
        aList.add("E");
        Boolean exist=arraylistContainStr(aList,"C");
        System.out.println(exist);
        if(aList.contains("H"))
            System.out.println("The element H is available in the ArrayList");
        else
            System.out.println("The element H is not available in the ArrayList");
    }
}