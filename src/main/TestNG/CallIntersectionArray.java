package main.TestNG;

import static main.util.intersection.findIntersection;

public class CallIntersectionArray {
    public static void main(String[] args) {
        String[] array1={"red", "blue", "blue", "green", "red"};
        String[] array2={"red", "green", "green", "yellow"};
        findIntersection(array1,array2);
        Integer[] array3= { 0 ,  1 , 2 ,  3 ,  4  ,  5  };
        Integer[] array4= {  4 ,  7 , 8 , 9 , 10 , 1 };
        findIntersection(array3,array4);
    }
}
