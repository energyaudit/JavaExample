package Java3;

import java.util.ArrayList;

public class HarshadNivenNumber {
    static void checkForHarshad(int inputNumber) {
        int copyOfInputNumber = inputNumber;

        int sum = 0;

        int lastDigit = 0;

        //Calculating the sum of digits of inputNumber

        while (inputNumber != 0) {
            lastDigit = inputNumber % 10;

            sum = sum + lastDigit;

            inputNumber = inputNumber / 10;
        }

        //Checking whether inputNumber is divisible by sum

        if ((copyOfInputNumber % sum) == 0) {
            System.out.println(copyOfInputNumber + " is a Harshad number");
        } else {
            System.out.println(copyOfInputNumber + " is not a Harshad number");
        }
    }

    public static void main(String[] args) {

        Integer[] arraytest ={21, 111, 153, 71};
        for (int i = 0; i < arraytest.length; i++) {
            checkForHarshad(arraytest[i]);

        }
    }
}
