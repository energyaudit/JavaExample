package main.util;





import java.util.ArrayList;

public class FirstMatchOccurrenceInArray {
    public static int first(ArrayList list, int x) {        // return first occurrence index of element x in ArrayList using method indexOf()
        return list.indexOf(x);
    }

    public static int last(ArrayList list, int x) {        // return last occurrence index of element x in ArrayListusing method lastIndexOf()
        return list.lastIndexOf(x);
    }
    public static int firstString(ArrayList list, String x) {        // return first occurrence index of element x in ArrayList using method indexOf()
        return list.indexOf(x);
    }

    public static int lastString(ArrayList list, String x) {        // return last occurrence index of element x in ArrayListusing method lastIndexOf()
        return list.lastIndexOf(x);
    }
    public static Integer returnFirstIndex(String[] inputArray,String word){
        ArrayList<String> clist = new ArrayList<>();
//        ArrayList<Integer> clist = new ArrayList<>();
        // adding elements of array to ArrayList
        for (String i : inputArray)
            clist.add(i);
        int x = 8;
Integer firstIndex=firstString(clist, word);
        // displaying the first occurrence
        System.out.println("First Occurrence = "
                + firstString(clist, word));

        // displaying the last occurance
        System.out.println("Last Occurrence = "
                + lastString(clist, word));
        return firstIndex;
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        ArrayList<Integer> clist = new ArrayList<>();
//        ArrayList<Integer> clist = new ArrayList<>();
        // adding elements of array to ArrayList
        for (int i : arr)
            clist.add(i);
        int x = 8;

        // displaying the first occurrence
        System.out.println("First Occurrence = "
                + first(clist, x));

        // displaying the last occurance
        System.out.println("Last Occurrence = "
                + last(clist, x));
        String arr1[] = {"1", "2", "2a", "2b", "8b", "8c"};
        System.out.println("First index is :"+returnFirstIndex(arr1,"8b"));
    }
}
