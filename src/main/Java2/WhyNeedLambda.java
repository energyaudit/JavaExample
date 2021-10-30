package main.Java2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class WhyNeedLambda {

    public static void main(String[] args) {
        Dog d1 = new Dog("Max", 2, 50);
        Dog d2 = new Dog("Rocky", 1, 30);
        Dog d3 = new Dog("Bear", 3, 40);

        Dog[] dogArray = {d1, d2, d3};
        printDogs(dogArray);

        Arrays.sort(dogArray, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        printDogs(dogArray);//call print dog method

        //with Lambda it is so simple,you pass function as argument
       System.out.println("with Lambda it is so simple,you pass function as argument");
        Arrays.sort(dogArray, (Dog m, Dog n) -> m.getWeight() - n.getWeight());
        printDogs(dogArray);
    }

    public static void printDogs(Dog[] dogs) {
        System.out.println("--Dog List--");
        for (Dog d : dogs)
            System.out.print(d);
        System.out.println();


    }
}