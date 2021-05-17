package main.Java2;

import com.google.common.collect.Lists;

import java.util.List;

public class GoogleListClass {
            public static void main(String[] args)
        {//1. Using Lists.asList() method
            int first = 10;
            int second = 20;
            Integer[] rest = { 30, 40, 50 };
            // The list contains 'first' element, followed by elements of
            // the 'rest' array
            List<Integer> firstList = Lists.asList(first, rest);
            System.out.println(firstList);
            // The list contains the 'first' and 'second' element, followed by
            // elements of the 'rest' array
            List<Integer> secondList = Lists.asList(first, second, rest);
            System.out.println(secondList);

            // List contains elements of the 'rest' array
            List<Integer> list = Lists.asList(null, rest)
                    .subList(1, rest.length + 1);
            System.out.println(list);
            //2.Using Lists.newArrayList() method
            // 2-1. Create an empty mutable `ArrayList`
            List<Integer> emptyList = Lists.newArrayList();
            System.out.println(emptyList);

            // 2-2. Create a mutable `ArrayList` from elements of the given array
            Integer[] ints = { 1, 2, 3 };
            List<Integer> list2 = Lists.newArrayList(ints);
            System.out.println(list2);
        }
    }
