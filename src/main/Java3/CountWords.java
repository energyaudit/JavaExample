package main.Java3;

import java.util.Arrays;
import java.util.HashMap;

public class CountWords {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "This this is is done by Saket Saket";
        String[] split = str.split(" ");
        HashMap<String,Integer> map = new HashMap<String,Integer>();//key type String, Value Integer
        for (int i=0; i<split.length; i++) {
            if (map.containsKey(split[i])) {
                int count = map.get(split[i]);//this word count+1
                map.put(split[i], count+1);
            }
            else {
                map.put(split[i], 1);
            }
        }//there is a bug that last one
        System.out.println(map);
        //count elements in array by call method  arrayElementCount
        arrayElementCount(new int[]{4, 5, 4, 5, 4, 6});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{12, 9, 12, 9, 10, 9, 10, 11});
        System.out.println("-------------------------");
        arrayElementCount(new int[]{891, 187, 891, 187, 891, 476, 555, 741});
    }
//count elements in array method
static void arrayElementCount(int inputArray[])
{
    //Creating a HashMap object with elements of inputArray as keys and their count as values
    HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
    //checking every element of the inputArray
    for (int i : inputArray)
    {
        if(elementCountMap.containsKey(i))
        {   //If element is present in elementCountMap, incrementing it's count by 1
            elementCountMap.put(i, elementCountMap.get(i)+1);
        }
        else
        {   //If element is not present in elementCountMap,
            //adding this element to elementCountMap with 1 as it's value
            elementCountMap.put(i, 1);
        }
    }
    System.out.println("Input Array : "+ Arrays.toString(inputArray));
    System.out.println("Element Count : "+elementCountMap);
}

}
