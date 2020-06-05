package util;


import java.util.Arrays;
import java.util.HashSet;

public class unionOfArrays {
 public static<T> void union(T[]... inputArrays) {//T[]...  means the paramaeters nubmer is changeable
        HashSet<T> unionSet = new HashSet<T>();

        System.out.println("Input Arrays :");

        System.out.println("======================");

        for (T[] inputArray : inputArrays) {
            System.out.println(Arrays.toString(inputArray));

            for (T i : inputArray) {
                unionSet.add(i);
            }
        }

        System.out.println("===========================");
        System.out.println("Union Of All Input Arrays :");
        System.out.println("===========================");
        System.out.println(unionSet);
    }

    public static void main(String[] args) {
        Integer[] inputArray1 = {2, 3, 4, 7, 1};//if use generic,make sure use
        Integer[] inputArray2 = {4, 1, 3, 5};
        Integer[] inputArray3 = {8, 4, 6, 2, 1};
        Integer[] inputArray4 = {7, 9, 4, 1};
        union(inputArray1, inputArray2, inputArray3, inputArray4);
    }
}