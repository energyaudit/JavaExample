package src.main.Java0;

import java.util.Arrays;

/**
 * Created by byang on 2018-06-26.
 */

public class ReflectionGetPubMethod {
    public static void main(String args[]){
        try {
            Class c=Class.forName("src.main.Java0.Rectangle");
            System.out.println(Arrays.toString(c.getMethods()));//get all methods

            System.out.println(Arrays.toString(c.getFields()));//get all fields

        } catch (Exception e) {
            e.printStackTrace();
        }
//Arrays.toString() Returns a string representation of the contents of the specified array.
// The string representation consists of a list of the array’s elements, enclosed in square brackets (“[]”)
        boolean[] boolArr = new boolean [] {true,true,false,true};
        byte[] byteArr = new byte[] {10,20,30};
        char[] charArr = new char [] {'g','e','e','k','s'};
        double[] dblArr = new double [] {1,2,3,4};
        float[] floatArr = new float [] {1,2,3,4};
        int[] intArr = new int [] {1,2,3,4};
        long[] lomgArr = new long [] {1,2,3,4};
        Object[] objArr = new Object [] {1,2,3,4};
        short[] shortArr = new  short [] {1,2,3,4};

        System.out.println(Arrays.toString(boolArr));
        System.out.println(Arrays.toString(byteArr));
        System.out.println(Arrays.toString(charArr));
        System.out.println(Arrays.toString(dblArr));
        System.out.println(Arrays.toString(floatArr));
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(lomgArr));
        System.out.println(Arrays.toString(objArr));
        System.out.println(Arrays.toString(shortArr));
    }
}
