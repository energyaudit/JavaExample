package src.main.Java0;

import java.util.Arrays;

/**
 java.util.Arrays class has many useful methods to perform the operations on the arrays. deepToString() method is one such method.
 Arrays.deepToString() method is used to get the string representation of multidimensional arrays.
 */
class Testarray5{//a class can run as long as main exist
    public static void main(String args[]){
//creating two matrices
        int a[][]={{1,3,4},{3,4,5}};//2 rows, 3 columns
        int b[][]={{1,3,4},{3,4,5}};

//creating another matrix to store the sum of two matrices
        int c[][]=new int[2][3];

//adding and printing addition of 2 matrices
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                c[i][j]=a[i][j]+b[i][j];
                System.out.print(c[i][j]+" ");
            }
            System.out.println();//new line
        }
        //printing multi dimension arrays by deepToString
        String[][] twoDArray = new String[][] {
                {"ONE", "TWO", "THREE", "FOUR"},
                {"FIVE", "SIX", "SEVEN"},
                {"EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE"}
        };
        System.out.println("without deepToString,must use loop to print, if print directly"+twoDArray);
        System.out.println("Two Dimensional Array : ");
        //Printing two dimensional array contents using deepToString() method
        System.out.println(Arrays.deepToString(twoDArray));

        //Three Dimensional Array

        String[][][] threeDArray = new String[][][] {
                {
                        {"ONE", "TWO", "THREE"},
                        {"FOUR", "FIVE", "SIX", "SEVEN"}
                },
                {
                        {"EIGHT", "NINE", "TEN", "ELEVEN"},
                        {"TWELVE", "THIRTEEN", "FOURTEEN"}
                },
                {
                        {"FIFTEEN", "SIXTEEN"} ,
                        {"SEVENTEEN", "EIGHTEEN", "NINETEEN"},
                        {"TWENTY", "TWENTY ONE"}
                }
        };

        System.out.println("Three Dimensional Array : ");
        //Printing three dimensional array contents using deepToString() method
        System.out.println(Arrays.deepToString(threeDArray));

    }
}