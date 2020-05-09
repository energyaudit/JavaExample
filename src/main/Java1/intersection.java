package main.Java1;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
First, we remove the duplicated elements with distinct. Then, we use the filter to select the elements that are also contained in the otherList.
Finally, we convert our output with a Collector.
 */
public class intersection {
    static <T> void findIntersection(T[] arry1, T[] arry2){
        List<T> list = Arrays.asList(arry1);
        List<T> otherList = Arrays.asList(arry2);
        Set<T> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());
        System.out.println(result);
    }
    public static void main(String[] args) {
  String[] array1={"red", "blue", "blue", "green", "red"};
        String[] array2={"red", "green", "green", "yellow"};
        findIntersection(array1,array2);
       Integer[] array3= { 0 ,  1 , 2 ,  3 ,  4  ,  5  };
        Integer[] array4= {  4 ,  7 , 8 , 9 , 10 , 1 };
        findIntersection(array3,array4);
    }
}
