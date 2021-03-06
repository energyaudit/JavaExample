package main.Java3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author
 */
public class Streams1 {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        // filtering

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa2", "aaa1"


        // sorting

        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        // "aaa1", "aaa2"


        // mapping

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"


        // matching

        boolean anyStartsWithA = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true


        // counting

        long startsWithB = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3


        // reducing

        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"

        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        //Stream findFirst() returns an Optional (a container object which may or may not contain a non-null value)
        // describing the first element of this stream, or an empty Optional if the stream is empty
// Creating a List of Strings
        List<String> list = Arrays.asList("GeeksforGeeks", "for",
                "GeeksQuiz", "GFG");

        // Using Stream findFirst()
        Optional<String> answer = list.stream().findFirst();

        // if the stream is empty, an empty
        // Optional is returned.by Optional.get() method
        if (answer.isPresent()) {
            System.out.println("Stream find first : "+answer.get());
        }
        else {
            System.out.println("no value");
        }
// If we run the below program, most of the time, the result is 2, it looks like findAny() always returns the first
// element? But, there is no guaranteed for this, findAny() may return any element from a Stream.
        List<Integer> listFindAny = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> any = listFindAny.stream().filter(x -> x > 1).findAny();
        if (any.isPresent()) {
            Integer result = any.get();
            System.out.println("find any x in list>1: "+result);
        }



    }
}


