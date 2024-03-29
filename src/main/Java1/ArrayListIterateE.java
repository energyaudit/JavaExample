package src.main.Java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by byang on 2018-08-13.
 */



public class ArrayListIterateE  {

    public static void main(String[] argv) {

        // create list
        List<String> crunchifyList = new ArrayList<String>();

        // add 4 different values to list
        crunchifyList.add("eBay");
        crunchifyList.add("Paypal");
        crunchifyList.add("Google");
        crunchifyList.add("Yahoo");

        // iterate via "for loop"
        System.out.println("==> For Loop Example.");
        for (int i = 0; i < crunchifyList.size(); i++) {
            System.out.println(crunchifyList.get(i));
        }

        // iterate via "New way to loop"
        System.out.println("\n==> Advance For Loop Example..");
        for (String temp : crunchifyList) {
            System.out.println(temp);
        }

        // iterate via "iterator loop"
        System.out.println("\n==> Iterator Example...");
        Iterator<String> crunchifyIterator = crunchifyList.iterator();
        while (crunchifyIterator.hasNext()) {
            System.out.println(crunchifyIterator.next());
        }
        Iterator<String> crunchifyIterator1 = crunchifyList.iterator();
        crunchifyIterator1.forEachRemaining((crunchify) -> System.out.println(crunchify));


        // iterate via "while loop"
        System.out.println("\n==> While Loop Example....");
        int i = 0;
        while (i < crunchifyList.size()) {
            System.out.println(crunchifyList.get(i));
            i++;
        }

        // collection stream() src.main.util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==> collection stream() src.main.util....");
        crunchifyList.forEach((temp) -> {
            System.out.println(temp);
        }
         );/*Java ArrayList is NOT synchronized. To get synchronized list from ArrayList use static void synchronizedList(List list) method of Collections class.*/
        List list = Collections.synchronizedList(crunchifyList);
//binary search is much more fast than linear search
        ArrayList arrList = new ArrayList();
        arrList.add("1");
        arrList.add("4");
        arrList.add("2");
        arrList.add("5");
        arrList.add("3");
        int index = Collections.binarySearch( arrList,"4");

        System.out.println("\nbinary search is much more fast than linear search.Element found at : " + index);
    }
}
