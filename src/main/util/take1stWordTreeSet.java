package main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class take1stWordTreeSet {
    public static List take1stWordOnlyTreeSet(TreeSet inputTreeSet){

        List<String> list = new ArrayList<String>(inputTreeSet);
        System.out.println("before delete:" + list);
        for (int i = 0; i < list.size(); i++) {
            String[] words = list.get(i).split(" ");
            list.set(i, words[0]);
        }
        System.out.println("After delete:" + list);
        return list;
    }
    public static void main(String args[]) {
        TreeSet treeSet = new TreeSet();
        //Add objects to the HashSet.
        treeSet.add("JOHN B");
        treeSet.add("DANA F");
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
        take1stWordOnlyTreeSet(treeSet );
    }
}