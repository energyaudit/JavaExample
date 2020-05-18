package main.RestAssured;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static main.util.countOccur.countOccurences;

public class callCountOccur {
    public static void main(String args[])
    {
        Set treeSet = new TreeSet();
        //Add objects to the HashSet.
//        treeSet.add("JOHN B");
//        treeSet.add("DANA F");
//        treeSet.add("LISA S");
//        treeSet.add("LAUREN C");
//        treeSet.add("ARANSAS S");
//        treeSet.add("CAMI B");
//        treeSet.add("MARIA S");
//        treeSet.add("STEVEN H");
//        treeSet.add("MINDI K");
//        treeSet.add("SILMARA R");
//        treeSet.add("RICARDO M");
//        treeSet.add("ROBERT B");

        treeSet.add("JOHN");
        treeSet.add("DANA");
        treeSet.add("LISA S");
        treeSet.add("LAUREN C");
        treeSet.add("ARANSAS S");
        treeSet.add("CAMI B");
        treeSet.add("MARIA S");
        treeSet.add("STEVEN H");
        treeSet.add("MINDI K");
        treeSet.add("SILMARA R");
        treeSet.add("RICARDO M");
        treeSet.add("ROBERT B");
        String[] weekTest={"Sun   9:00 AM JOHN B.  10:30 AM JOHN B.  12:00 PM JOHN B","Mon   8:15 AM DANA F.  12:30 PM LISA S.  6:00 PM LISA S","Tue   11:15 AM LAUREN C.  12:15 PM LAUREN C.  5:15 PM ARANSAS S.  6:45 PM ARANSAS S","Wed   10:00 AM CAMI B.  12:15 PM CAMI B.  5:30 PM MARIA S","Thu   8:15 AM STEVEN H.  9:15 AM STEVEN H.  12:15 PM DIANE M.  5:15 PM MINDI K.  6:15 PM MINDI K","Fri   8:15 AM SILMARA R.  12:15 PM SILMARA R.  5:30 PM RICARDO M","Sat   8:30 AM ROBERT B.  10:00 AM ROBERT B.  11:30 AM ROBERT B"};
        System.out.println(weekTest[1]+":"+"DANA"+"::"+countOccurences(weekTest[1], "DANA"));
        for(int i = 0; i <weekTest.length;i++) {
           Iterator<String> itr = treeSet.iterator();
           while (itr.hasNext()) {
               System.out.println(weekTest[i]+":"+itr.next()+"::"+countOccurences(weekTest[i], itr.next()));
           }
       }
    }
}
