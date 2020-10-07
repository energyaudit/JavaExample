package main.util;

import java.util.List;
import java.util.stream.Collectors;

public class filterContainExpectList {

    public static List<String> filterListContainSpecificStr(List<String> inputlist, String str){
        List<String> containStr = inputlist.stream()
                .filter(s->s.contains(str))
                .collect(Collectors.toList());
        System.out.println("After filtering, The new list contain "+str+"is:  ");
        containStr.forEach(System.out::println);//method reference
        return containStr;
    }

    }
