package main.Java3;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    public static String fizzBuzz(int number) {
        if (number % 3 == 0) {
            if (number % 5 == 0) {
                return "fizzbuzz";
            } else {
                return "fizz";
            }
        } else if (number % 5 == 0) {
            return "buzz";
        }
        return String.valueOf(number);
    }

    public static String fizzBuzz2(int number) {
        if (number % 15 == 0) {
            return "fizzbuzz";
        } else if (number % 5 == 0) {
            return "buzz";
        } else if (number % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(number);
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("fizz", fizzBuzz(3));
        assertEquals("buzz", fizzBuzz(5));
        assertEquals("fizzbuzz", fizzBuzz(15));
        assertEquals("2", fizzBuzz(2));
    }

    @Test
    public void testFizzBuzz2() {
        assertEquals("fizz", fizzBuzz2(3));
        assertEquals("buzz", fizzBuzz2(5));
        assertEquals("fizzbuzz", fizzBuzz2(15));
        assertEquals("2", fizzBuzz2(2));
    }
}

