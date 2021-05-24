package main.Java1;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by byang on 23/5/2021.BiFunction is a functional interface whose functional method is
 * R apply(T t, U u). The BiFunction is interface represents an operation that takes
 * two arguments (T and U) and returns a result R
 */
public class BiFunctionInterfaceExp {

    public static void main(String[] args) {
        // following example shows how to use the apply() method of the BiFunction interface
        BiFunction<String, String, String> function1 = (s1, s2) -> {
            String s3 = s1 + s2;
            return s3;
        };
        System.out.println(function1.apply("BORAJI", ".COM"));

        BiFunction<Integer, Integer, Integer> function2 = (a, b) -> a + b;
        System.out.println(function2.apply(100, 200));
        //The following example shows how to use the default method andThen() of the BiFunction
        // interface with lambda expression
        BiFunction<Integer, Integer, Integer> function3 = (a, b) -> a + b;
        Function<Integer, Integer> function4 = (n) -> n*n;

        //Using andThen()
        System.out.println(function3.andThen(function4).apply(5, 3));
        System.out.println(function3.andThen(function4).apply(12, 2));
    }

}
