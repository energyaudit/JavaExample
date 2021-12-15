package main.Java2;


import main.util.JavaUtil;

import java.io.IOException;
import java.util.Arrays;

public class findMiddleOfArrayDemo
{
    public static void main(String args[]) throws IOException {
        //Original array
        int arr[] = {12, 22, 34, 22, 54, 6, 52, 8, 9, 34, 54, 68,10,20,30};
        JavaUtil util=new JavaUtil();
        int Middle=util.findMiddleOfArray(arr);

        String[] colors = {"red","green","blue","white","orange"};
        util.findMiddleOfArray(colors);
    }
}