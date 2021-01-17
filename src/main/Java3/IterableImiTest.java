package main.Java3;
/**
 * Byang,15/01/2021
 * The Java Iterable interface (java.lang.Iterable) is one of the root interfaces of the Java Collections API.
 * The Collection interface extends Iterable, so all subtypes of Collection also implement the Iterable interface.
 * For instance, both the Java List and Set interfaces extend the Collection
 */

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;

class IterableImi<T> implements Iterable<T> {

    private List<T> list;

    public IterableImi(T [] t) {

        list = Arrays.asList(t);
        Collections.reverse(list);
    }

    @Override
    public Iterator<T> iterator() {

        return list.iterator();
    }
}
public class IterableImiTest {

    public static void main(String [] args) {

        Integer [] ints = {1, 2, 3};

        IterableImi<Integer> myList = new IterableImi<>(ints);

        for (Integer i : myList) {

            System.out.println(i);
        }
    }
}
