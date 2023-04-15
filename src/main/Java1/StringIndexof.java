package main.Java1;

public class StringIndexof {
    public static void main(String args[])
    {
        // Initialising String
        String gfg = new String("Welcome to geeksforgeeks");
        System.out.print("Found g first at position : ");
        // Initial index of 'g' will print  11
        System.out.println(gfg.indexOf('g'));
//int indexOf(String str) : This method returns the index within this string of the first occurrence
// of the specified substring. If it does not occur as a substring, -1 is returned.
        System.out.print("Found g after 13th index at position : ");

        // 2nd index of 'g' will 19
        System.out.println(gfg.indexOf('g', 13));


    }

}
