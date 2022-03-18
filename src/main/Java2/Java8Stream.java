package src.main.Java2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/**
 * Created by byang on 2018-09-17.
 * You can add to or remove elements from collections. But, you can’t add to or remove elements from streams.
 * Stream consumes a source, performs operations on it and returns a result. They don’t modify even the
 * source also.The features of Java stream are –
 *
 * A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
 * Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
 * Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.
 *
 */
public class Java8Stream {
    static int i=0;
    private static int next(){
        i++;// you will need to use a Supplier that stores the last generated element. The following code keeps the last value in a static variable.
        return i;}

    public static void main(String[] args) {
/*
*The main specialty of Java 8 Streams is that you need not to worry about iteration while using streams.
*  Streams perform iteration internally behind the scene for you. You just have to mention the
* operations to be performed on a source.
 */
        List<String> names1 = new ArrayList<>();
        names1.add("Charlie");
        names1.add("Douglas");
        names1.add("Sundaraman");
        names1.add("Charlie");
        names1.add("Yuki");

//External iteration of collections

        for (String name : names1)
        {
            System.out.println(name);
        }


//Internal iteration of streams. No for loops
        names1.stream().map(String::toUpperCase).forEach(System.out::println);
//Reduce,The JDK contains many terminal operations (such as average, sum, min, max, and count) that return one value
// by combining the contents of a stream. These operations are called reduction operations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n % 2  == 1)
                .map(n  -> n * n)
                .reduce(0, Integer::sum);//reduce operation takes two parameters called a seed (initial value) and an accumulator.

        System.out.println(sum);

        int sum1 = numbers.parallelStream()
                .filter(n -> n % 2  == 1)
                .map(n  -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sum1);
//filter
        List<Integer> numbers1 = Arrays.asList(3,7,9,3,1,2,1, 2, 3, 4, 5);//returns a fixed-size list by the specified array
        numbers1.stream()
                .filter(n -> n % 2  == 1)
                .sorted()
                .forEach(System.out::println);

        Stream.generate(Math::random)//generate(Supplier<T> s) uses Supplier to generate an infinite sequential unordered stream.
                .limit(5)
                .forEach(System.out::println);
System.out.println("ramdom integers: ");
        new Random().ints()//java.src.main.util.Random class provides ints(), longs(), and doubles() return infinite IntStream, LongStream, and DoubleStream, respectively.
                .limit(5)
                .forEach(System.out::println);

   /**      Different Operations On Streams-
                * Intermediate Operations:
 *
 * map: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.
                * List number = Arrays.asList(2,3,4,5);
 * List square = number.stream().map(x->x*x).collect(Collectors.toList());
 * filter: The filter method is used to select elements as per the Predicate passed as argument.
                * List names = Arrays.asList("Reflection","Collection","Stream");
 * List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
 * sorted: The sorted method is used to sort the stream.
                * List names = Arrays.asList("Reflection","Collection","Stream");
 * List result = names.stream().sorted().collect(Collectors.toList());
 * Terminal Operations:
 *
 * collect: The collect method is used to return the result of the intermediate operations performed on the stream.
                * List number = Arrays.asList(2,3,4,5,3);
 * Set square = number.stream().map(x->x*x).collect(Collectors.toSet());
 * forEach: The forEach method is used to iterate through every element of the stream.
                * List number = Arrays.asList(2,3,4,5);
 * number.stream().map(x->x*x).forEach(y->System.out.println(y));
 * reduce: The reduce method is used to reduce the elements of a stream to a single value.
 * The reduce method takes a BinaryOperator as a parameter.
                * List number = Arrays.asList(2,3,4,5);
 * int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
*/
        //Java Stream From Functions
        Stream.generate(Java8Stream::next)//To generate a stream in which the next element is generated based on the previous one,
               .limit(5)//
                .forEach(System.out::println);

        Set<String> names = new HashSet<>();
        names.add("XML");
        names.add("Java");

        Stream<String> sequentialStream  = names.stream();
        sequentialStream.forEach(System.out::println);

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(System.out::println);
//Streams from Regex
        String str = "XML,CSS,HTML";
        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(System.out::println);

       long count = LongStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(i -> i%2 == 0).count();//Count Number of Elements Using Stream.count()
        System.out.printf("There are %d elements in the stream %n", count);
        //printf is format print and %d is format of integer

        int[] a = {1,2,3,4};//judge if a array contains a integer
        boolean contains = IntStream.of(a).anyMatch(x -> x == 4);
        System.out.println(contains);
        count = Stream.of(1,2,3,4,5,6,7,8,9).filter(i -> i%2 == 0).collect(Collectors.counting());//Count Number of Elements Using Collectors.counting()
        System.out.printf("There are %d elements in the stream %n", count);
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
// Get collection without duplicate i.e. distinct only
        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
//Let's verify distinct elements
        System.out.println(distinctElements);

        //A List of Strings to Uppercase
        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]
        // Java 8 stream map method
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

    }
    }
