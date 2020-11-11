package main.Java3;

import main.util.JavaUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCallJavaUtil {
    @Test
    public void arrayContainsInt(){
JavaUtil jul=new JavaUtil();
        int[] a = {1,2,3,4};
        boolean contains=jul.ArrayContains(a,4);
        System.out.println("array contains this int?"+contains);
    }

    @Test
    public void ListContainsInt(){
        JavaUtil jul=new JavaUtil();
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        boolean contains=jul.ListIntContains(arr,4);
        System.out.println("List contains this int?"+contains);
    }
    @Test
    public void ListContainsStr(){
        JavaUtil jul=new JavaUtil();
        List<String> arr = new ArrayList<String>();
        arr.add("geeks");
        arr.add("for");
        arr.add("geeks");
        boolean contains=jul.ListStrContains(arr,"geeks");
        System.out.println("List contains this int?"+contains);
    }




















}
