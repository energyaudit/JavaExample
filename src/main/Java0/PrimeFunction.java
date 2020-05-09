package main.Java0;

public class PrimeFunction {
    static void  isPrime( int num){
        int temp;
        boolean isPrime = true;

        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println(num + ":number is prime");
        else
            System.out.println(num + ":number is not a prime");
    }
    public static void main(String[] args) {
isPrime(35);
int[] test={30,31,29,27,11,18};
     for(int i=0;i<test.length;i++) {
       isPrime(test[i]);
     }
    }
}
