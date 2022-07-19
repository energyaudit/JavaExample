package main.Java3;


import org.apache.commons.lang3.StringUtils;

public class StringUtilsIsBlank {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = null;
        String s3 = " ";
        String s4 = "jack";
        System.out.println(StringUtils.isBlank(s1)); // true
        System.out.println(StringUtils.isBlank(s2)); // true
        System.out.println(StringUtils.isBlank(s3)); // true
        System.out.println(StringUtils.isBlank(s4)); // false
    }
}