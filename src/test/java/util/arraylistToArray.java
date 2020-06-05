package util;

import java.util.*;
public class arraylistToArray {
    public static String[] ArrayListToArray(List listIn){
        String[] array = new String[listIn.size()];
        listIn.toArray(array);//list's toArray() method to convert the list items to array items.
        System.out.println(Arrays.toString(array));
        return array;
    }
    public static void main(String args[]) {

        /*ArrayList declaration and initialization*/
        ArrayList<String> arrlist= new ArrayList<String>();
        Collections.addAll(arrlist, "Apple","Banana","Mango","Pear");
        /*ArrayList to Array Conversion */
        String array[] = new String[arrlist.size()];
        for(int j =0;j<arrlist.size();j++){
            array[j] = arrlist.get(j);
        }
        /*Displaying Array elements*/
        for(String k: array)
        {
            System.out.println(k);
        }

        //method2:
        ArrayList<String> arrlist2= new ArrayList<String>();
        Collections.addAll(arrlist2, "Apple","Banana","Mango","Pear");
        ArrayListToArray(arrlist2);
    }
}
