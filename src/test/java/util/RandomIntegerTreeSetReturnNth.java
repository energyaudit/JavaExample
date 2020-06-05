package util;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class RandomIntegerTreeSetReturnNth {
    public static TreeSet randomSet(Integer size){
        Random random = new Random();
        TreeSet treeSet = new TreeSet();
        for(int i = 0; i <size;i++){
            int rand=random.nextInt();
            treeSet.add(rand);
        }
        System.out.println(treeSet);
        return treeSet;
    }
    public static Integer nthSmallTreeset(TreeSet treeSet, Integer n){
        System.out.println("Because treeset is sorted so the nth:(  "+n+" )smallest will be the (n-1)th element:set[n]:   ");
        //get an iterator
        Iterator<Integer> itr = treeSet.iterator();
        int desiredIndex = n-1;//desiredSmall nth
        int currentIndex = 0;
        Integer currentElement = null;
        while( itr.hasNext() ){//iterate the TreeSet
            currentElement = itr.next();
            if( currentIndex == desiredIndex ){
                System.out.println("Element at index " + desiredIndex + " is: " + currentElement);
                break;
            }
            currentIndex++;
        }
        return currentElement;
    }
    public static void main(String args[]) {
     TreeSet  treeSet= randomSet(500);
        Integer nthSmall=nthSmallTreeset(treeSet,5);
        for(int i=8;i<30;i++){
            nthSmallTreeset(treeSet,i);
        }
    }
}
