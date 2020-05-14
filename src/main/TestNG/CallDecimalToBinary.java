package main.TestNG;

import static main.util.DecimalToBinary.DecimalToBina;

public class CallDecimalToBinary {
    public static void main(String args[])
    {
        String[] test={"128","56","29"};
        for(int i=0;i<test.length;i++){
            DecimalToBina(test[i]);
        }
    }
}
