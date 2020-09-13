package main.Java3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class assertNotEqualExp {
    public static String method1() {
        return null;
    }

    public static String method2() {
        return "Ramesh";
    }

    public static String method3() {
        return "Fadatare";
    }



    @Test
    public void assertNotEqualsTest() {
        assertNotEquals("null", method1());
        assertNotEquals("ramesh", method2());
        assertNotEquals("fadatare", method3());
    }
    @Test
    void testCase() {

        boolean trueBool = true;
        boolean falseBool = false;

        Assertions.assertTrue(trueBool);
        Assertions.assertTrue(falseBool, "test execution message");
        Assertions.assertTrue(falseBool, assertNotEqualExp::message);
        Assertions.assertTrue(assertNotEqualExp::getResult,assertNotEqualExp::message);

        Assertions.assertFalse(falseBool);
        Assertions.assertFalse(trueBool, "test execution message");
        Assertions.assertFalse(trueBool, assertNotEqualExp::message);
        Assertions.assertFalse(assertNotEqualExp::getResult, assertNotEqualExp::message);
    }

    private static String message () {
        return "Test execution result";
    }

    private static boolean getResult () {
        return true;
    }
}