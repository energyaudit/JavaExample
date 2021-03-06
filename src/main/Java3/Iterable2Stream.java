package main.Java3;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Iterable2Stream {

    public static void main(String[] args) {

        List<String> valuesList = new ArrayList<>();
        valuesList.add("java 8");
        valuesList.add("example");
        valuesList.add("blog");
        valuesList.add("2019");

        Stream<String> stream = StreamSupport.stream(valuesList.spliterator(), false);
        stream.forEach(System.out::println);
/**
 * An example is the same as an above program but it takes argument parallel as true in stream() method.
 * True indicates that it creates a new parallel stream instead of a sequential stream
 */
        Stream<String> stream1 = StreamSupport.stream(valuesList.spliterator(), true);
        stream1.forEach(System.out::println);
    }

}