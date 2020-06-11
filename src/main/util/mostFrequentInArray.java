package main.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mostFrequentInArray {
   public static <T> T getMostFrequentElement(T[] inputArray)
    {
        //Creating HashMap object with elements as keys and their occurrences as values
        HashMap<T, Integer> elementCountMap = new HashMap<T, Integer>();
        //Inserting all the elements of inputArray into elementCountMap
        for (T i : inputArray)
        {
            if (elementCountMap.containsKey(i))
            {
                //If an element is present, incrementing its count by 1
                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else
            {
                //If an element is not present, put that element with 1 as its value
                elementCountMap.put(i, 1);
            }
        }
        T element=null ;
        int frequency = 1;
        //Iterating through elementCountMap to get the most frequent element and its frequency
        Set<Map.Entry<T, Integer>> entrySet = elementCountMap.entrySet();
        for (Map.Entry<T, Integer> entry : entrySet)
        {
            if(entry.getValue() > frequency)
            {
                element = entry.getKey();
                frequency = entry.getValue();
            }
        }
        //Printing the most frequent element in array and its frequency
        if(frequency > 1)
        {
            System.out.println("Input Array : "+ Arrays.toString(inputArray));
            System.out.println("The most frequent element : "+element);
            System.out.println("Its frequency : "+frequency);
            System.out.println("========================");
        }
        else
        {
            System.out.println("Input Array : "+Arrays.toString(inputArray));
            System.out.println("No frequent element. All elements are unique.");
            System.out.println("=========================");
        }
        return element;
    }

    public static void main(String[] args)
    {
        Integer result=getMostFrequentElement(new Integer[]{4, 5, 8, 7, 4, 7, 6,7});
        System.out.println(result);
        getMostFrequentElement(new Integer[]{1, 2, 7, 5, 3, 6});
       Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        Character result1=getMostFrequentElement(charArray);
        System.out.println(result1);
    }
}
