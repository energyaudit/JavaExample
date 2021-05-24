package main.Java0;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Why flat a Stream?
 * 2.1 It’s challenging to process a Stream containing more than one level, like Stream<String[]> or
 * Stream<List<LineItem>> or Stream<Stream<String>>
 */
public class flatMapExp {
    public static void main(String args[]){
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a,only !=a staty
                .collect(Collectors.toList());      // return a List

        collect.forEach(System.out::println);
    }
}
