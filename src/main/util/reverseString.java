package main.util;

public class reverseString {
    public static StringBuffer reverseStr(String strin){
        StringBuffer sb6=new StringBuffer(strin);
        sb6.reverse();//The reverse() method of StringBuilder class reverses the current string.
        System.out.println("use string buffer reverse string:  "+sb6);//prints olleH
        return sb6;
    }
    public static void main(String args[]){
       String str="Hello";
        reverseStr(str);
    }
}
