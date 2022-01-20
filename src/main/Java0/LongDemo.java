package main.Java0;


public class LongDemo {
    public static void main(String[] args) {
        // Returns a Long object.
        Long val=12l;
        System.out.println("The valueOf() method returns : "+Long.valueOf(val));
        String str="369876543234567890";
        System.out.println("The valueOf() method returns : "+Long.valueOf(str));
    }
}