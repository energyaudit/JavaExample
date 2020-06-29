package main.util;

public class shortestStrInArray {
    public static String shortestStrInArray(String[] strArr)
    {
        String minStr=strArr[0];
        for(int i=1;i<strArr.length;i++){
            if(strArr[i].length()<minStr.length())
                minStr=strArr[i];
        }
        return minStr;
    }
    public static void main(String[] args)
    {
        String[] strArr={"java2blog","javaworld","javabean","javatemp"};
        String shortestStr=shortestStrInArray(strArr);
        System.out.println("Longest Prefix : "+shortestStr);
    }
}
