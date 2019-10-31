package src.main.Java0;

/**
 * Created by byang on 1/19/2018.
 */
public class TernaryOperator
{
    public static void main(String args[]){
        int a=2;
        int b=5;
        int min=(a<b)?a:b;//TernaryOperator
        System.out.println(min);

        // min value example
        int minVal, a1=3, b1=2;
        minVal = a1 < b1 ? a1 : b1;//you not need () for the boolean expression
        System.out.println("min = " + minVal);

        // absolute value example
        a = -10;
        int absValue = (a < 0) ? -a : a;
        System.out.println("abs = " + absValue);

        // result is assigned the value 1.0
        float result = true ? 1.0f : 2.0f;
        System.out.println("float = " + result);

        // result is assigned the value "Sorry Dude, it's false"
        String s = false ? "Dude, that was true" : "Sorry Dude, it's false";
        System.out.println(s);

        // example using the ternary operator on the rhs, in a string
        int x = 5;
        String out = "There " + (x > 1 ? " are " + x + " cookies" : "is one cookie") + " in the jar.";
        System.out.println(out);
    }
}
