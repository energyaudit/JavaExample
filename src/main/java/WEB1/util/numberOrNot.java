package WEB1.util;

public class numberOrNot {
    static boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        String input="123.56";
        if(numberOrNot(input) && (input.length() == 10))
        {
            System.out.println("Good!!! You have entered valid mobile number");
        }
        else
        {
            System.out.println("Sorry!!!! You have entered invalid mobile number. Try again...");
        }
        String[] test={"123","123e","5689.0","abcd"};
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]+"  :is number?   "+numberOrNot(test[i]));
        }
    }}


