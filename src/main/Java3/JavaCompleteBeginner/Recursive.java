package main.Java3.JavaCompleteBeginner;


public class Recursive {
    public static int fact(int number){
        int result = 1;
        while(number != 0){
            result = result*number;
            number--;
        }

        return result;
    }

    private static int factorial(int value) {
        //System.out.println(value);
        if(value == 1) {
            return 1;
        }
        return factorial(value - 1) * value;
    }


    public static void main(String[] args) {
        // E.g. 4! = 4*3*2*1 (factorial 4)
        System.out.println(factorial(5));
        System.out.println(fact(6));
    }



}