package main.Java3;



public class pyramidPattern
{
    public static void main(String[] args)
    {
        int noOfRows = 6;
        //Initializing rowCount with 1
        int rowCount = 1;
        System.out.println("Here Is Your Pyramid");
        for (int i = noOfRows; i > 0; i--)      //Implementing the logic
        {
            //Printing i spaces at the beginning of each row
            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }
            //Printing 'rowCount' value 'rowCount' times at the end of each row
            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print(rowCount+" ");
            }
            System.out.println();
            //Incrementing the rowCount
            rowCount++;
        }
    }
}