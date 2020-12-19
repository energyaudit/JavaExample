package main.Java3.JavaCompleteBeginner;


import java.util.ArrayList;
        import java.util.List;

public class ArrayListEasy {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Adding
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        // Retrieving
        System.out.println(numbers.get(0));

        System.out.println("nIteration #1: ");
        // Indexed for loop iteration
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // Removing items (careful!)
        numbers.remove(numbers.size() - 1);

        // This is VERY slow
        numbers.remove(0);

        System.out.println("nIteration #2: ");
        for (Integer value : numbers) {
            System.out.println(value);
        }

        // List interface ...
        List<String> values = new ArrayList<String>();
        //if there are duplicated value, indexof will return index of first occurrence,if you want last one use
        // lastIndexOf() method
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(90);
        al.add(15);
        al.add(20);
        al.add(90);

        System.out.println("Index of 90: "+al.indexOf(90));
        System.out.println("Last Index of 19: "+al.lastIndexOf(90));

    }
}