package main.util;


import java.util.*;
import java.util.stream.Collectors;

public class                                                                                                                                                                                                                                                                                                                               ConvertArrayToSet {
public static<T> Set arrayToTreeset(T[] arrayInput){
        /*First we convert an Array to List using,Arrays.asList(), then pass the list as an
      argument to the constructor of TreeSet */
    List list = Arrays.asList(arrayInput);
    Set set = new TreeSet(list);
    System.out.println("The Set elements are :");       // Show Set elements
    System.out.println("Set: " + set);
return set;
}
    public static void main(String[] args) {
//method1:array to hashet,to list first then to set
        String[] array = {"a", "b", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Set: " + set);
//method2:array to hashet,to stream first then use collect method to set
        String[] array1 = {"a", "b", "c", "d", "d"};
        Set<String> set1 = new HashSet<>(Arrays.stream(array1).collect(Collectors.toSet()));
        System.out.println("Set1: " + set1);
//method3: array to treeset,treeset is ordered
        Integer[] num = {7, 34, 45, 23, 38, 56, 21, 38};
        arrayToTreeset(num);
        arrayToTreeset(array);
//        List<Integer> list = Arrays.asList(num);
//        Set<Integer> set3 = new TreeSet<Integer>(list);
//        System.out.println("The Set3 elements are :");       // Show Set elements
//        System.out.println("Set3: " + set3);
    }
}
