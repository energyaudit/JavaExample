package main.util;

public class removeLineBreaks {
    public static String removeLbr(String strin){
        System.out.println("**********Orignal Text**********");
        System.out.println(strin);
        strin = strin.replace("\n", "");
        System.out.println("**********Modified Text********");
        System.out.println(strin);
        return strin;
    }
    public static void main(String[] args) {
        String text = "abcdefghij \n"
                + "klmnopq\n zzzz";
        removeLbr(text);
    }
}
