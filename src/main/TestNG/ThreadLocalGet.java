package main.TestNG;


import java.lang.*;



public class ThreadLocalGet {

    public static void main(String[] args) {

        ThreadLocal<Integer> tlocal = new ThreadLocal<Integer>();

        tlocal.set(100);
        // returns the current thread's value
        System.out.println("value = " + tlocal.get());

        tlocal.set(90);
        // returns the current thread's value of
        System.out.println("value = " + tlocal.get());
    }
}