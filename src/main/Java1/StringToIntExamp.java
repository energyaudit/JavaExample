package src.main.Java1;

public class StringToIntExamp {
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
        String s="200";//In Java, strings are objects, not primitive types such as int, double, char, and boolean
        int i=Integer.parseInt(s);
        System.out.println(s+100);//200100 because + is string concatenation operator
        System.out.println(i+100);//300 because + is binary plus operator
        //use function numberornot analyze if a input is number and length less than 10
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
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
        for(i=0;i<test.length;i++){
            System.out.println(test[i]+"  :is number?   "+numberOrNot(test[i]));
        }
    }}

