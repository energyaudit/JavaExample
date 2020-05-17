package main.RestAssured;

import java.util.TreeSet;

import static main.util.RandomIntegerTreeSetReturnNth.nthSmallTreeset;
import static main.util.RandomIntegerTreeSetReturnNth.randomSet;

public class callRandomTreeSetNthSmall {
    public static void main(String args[]) {
        TreeSet treeSet= randomSet(500);
        Integer nthSmall=nthSmallTreeset(treeSet,5);
        for(int i=8;i<30;i++){
            nthSmallTreeset(treeSet,i);
        }
    }
}
