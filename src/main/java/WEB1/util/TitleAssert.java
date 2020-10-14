package WEB1.util;

public class TitleAssert {
    public static void titleAssert(Integer n,String actual, String expect){
        if(actual.equalsIgnoreCase(expect))
            System.out.println("The"+n+" Title Matched");
        else
            System.out.println("The"+n+" Title didn't match");
    }
}
