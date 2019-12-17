package main.Java3.JavaCompleteBeginner;


import java.util.ArrayList;

class Machine1 {

    @Override
    public String toString() {
        return "I am a machine";
    }

    public void start() {
        System.out.println("Machine starting.");
    }

}

class Camera1 extends Machine1 {
    @Override
    public String toString() {
        return "I am a camera";
    }

    public void snap() {
        System.out.println("snap!");
    }
}

public class GenericWildcards {

    public static void main(String[] args) {

        ArrayList<Machine1> list1 = new ArrayList<Machine1>();

        list1.add(new Machine1());
        list1.add(new Machine1());

        ArrayList<Camera1> list2 = new ArrayList<Camera1>();

        list2.add(new Camera1());
        list2.add(new Camera1());

        showList(list2);
        System.out.println("showList2(list1)");
        showList2(list1);
        System.out.println("showList2(list2)");
        showList2(list2);
        showList3(list1);
    }

    public static void showList(ArrayList<? extends Machine1> list) {// "? extends Machine1" means the generic type can be machine1 or son camera etc
        for (Machine1 value : list) {
            System.out.println(value);
            value.start();
        }

    }

    public static void showList2(ArrayList<? super Camera1> list) {//"? super Camera1" means camera or super class
        for (Object value : list) {
            System.out.println(value);
        }
    }

    public static void showList3(ArrayList<?> list) {//? is wildcard
        for (Object value : list) {//object is parent of any class so parent of machine1 and camera1 for sure,when you not know it is machine1 or camera1 ,just pass object
            System.out.println(value);
        }
    }


}