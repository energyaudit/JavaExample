package main.Java0;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class CollectorsToSetMethod {
    public static void main(String[] args)
    {
        // creating a Stream of strings
        Stream<String> s = Stream.of("Geeks","Geeks",
                "for",
                "GeeksforGeeks",
                "Geeks Classes");//duplicated element will be deleted

        // using Collectors toSet() function
        Set<String> mySet = s.collect(Collectors.toSet());

        // printing the elements
        System.out.println(mySet);

        Stream<String> s1 = Stream.of("1", "2", "2","3","3", "4");//duplicated element will be deleted

        // using Collectors toSet() function
        Set<String> mySet1 = s1.collect(Collectors.toSet());

        // printing the elements
        System.out.println(mySet1);
    }
}
