package main.TestNG;

import static main.util.ConvertArrayToTreeset.arrayToTreeset;

public class CallArrayToTreeSet {
    public static void main(String[] args) {
        String[] array = {"a", "b", "b", "c"};
        String[] array1 = {"a", "b", "c", "d", "d"};
        Integer[] num = {7, 34, 45, 23, 38, 56, 21, 38};
        arrayToTreeset(num);
        arrayToTreeset(array);
        arrayToTreeset(array1);

    }
}


