package src.main.Java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by byang on 2018-06-29.
 * It is compact and easy form of lambda expression.
 */
//@FunctionalInterface
interface MyInterface{
    void display();

}
class Multiplication{
    public static int multiply(int a, int b){
        return a*b;
    }
}

 class InstanceM {
    public void myMethod(){
        System.out.println("1. Method reference to an instance method of an object – object::instanceMethod\n" +
                "2. Method reference to a static method of a class – Class::staticMethod\n" +
                "3. Method reference to an instance method of an arbitrary object of a particular type – Class::instanceMethod\n" +
                "4. Method reference to a constructor – Class::new\nJava8:Instance Method\n");
    }

    public static void main(String[] args) {
        InstanceM objM = new InstanceM();
        // Method reference using the object of the class
        MyInterface ref = objM::myMethod;//Method reference to an instance method of an object
        // Calling the method of functional interface
        ref.display();

        BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;
        int pr = product.apply(11, 5);
        System.out.println("Java8:class static method::Product of given number is: "+pr);

        List<Integer> integers = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));//Reference to constructor – Class::new
        //we need to perform operations where a stream reduces to single resultant value
        Optional<Integer> max = integers.stream().reduce(Math::max);
        max.ifPresent(System.out::println);

        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array.stream().reduce(0,
                (element1, element2) -> element1 + element2);

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);

        // Creating an IntStream ,understanding boxed
        IntStream stream = IntStream.range(3, 8);
System.out.println("understanding stream boxed");
        // Creating a Stream of Integers
        // Using IntStream boxed() to return
        // a Stream consisting of the elements
        // of this stream, each boxed to an Integer.
        Stream<Integer> stream1 = stream.boxed();

        // Displaying the elements
        stream1.forEach(System.out::println);
    }
}
