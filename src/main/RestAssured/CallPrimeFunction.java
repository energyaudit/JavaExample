package main.RestAssured;

import static main.util.PrimeFunction.isPrime;

public class CallPrimeFunction {
    public static void main(String[] args) {
        isPrime(35);
        int[] test={30,31,29,27,11,18};
        for(int i=0;i<test.length;i++) {
            isPrime(test[i]);
        }
    }
}
