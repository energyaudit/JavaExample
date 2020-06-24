package util;

import java.util.HashMap;
import java.util.Set;

public class MostFrequencyDigitInNumber {
    public static HashMap<Integer, Integer> MostFrequencyDigitInNumber (Integer inputNumber){
        //Creating a HashMap object with digits as keys and their frequency as values
        HashMap<Integer, Integer> digitCountMap = new HashMap<Integer, Integer>();
        while (inputNumber != 0)
        {
            //Get the lastDigit of inputNumber
            int lastDigit = inputNumber % 10;
            if(digitCountMap.containsKey(lastDigit))
            {
                //If lastDigit is already present in the map, incrementing its frequency by 1
                digitCountMap.put(lastDigit, digitCountMap.get(lastDigit)+1);
            }
            else
            {
                //If lastDigit is not present in the map, inserting lastDigit into map with 1 as its value
                digitCountMap.put(lastDigit, 1);
            }
            //Removing the lastDigit from inputNumber
            inputNumber = inputNumber / 10;
        }
        //Printing digits and their frequency
        System.out.println("===================");
        System.out.println("Digits : Frequency");
        System.out.println("===================");
        Set<Integer> keys = digitCountMap.keySet();
        for (Integer key : keys)
        {
            System.out.println("   "+key+"   :   "+digitCountMap.get(key));
        }
        return digitCountMap;
    }


    public static void main(String[] args)
    {
Integer[] test={21757132,31757135,51757133};
for (int i=0;i<test.length;i++){
    MostFrequencyDigitInNumber(test[i]);
}
}
}
