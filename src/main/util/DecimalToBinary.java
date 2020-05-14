package main.util;

public class DecimalToBinary {
 public static void DecimalToBina(String numInput){
       Integer num = Integer.parseInt(numInput);//must change string into integer first
        String hexa = Integer.toHexString(num);
        System.out.println("HexaDecimal Value is : " + hexa);
        String octal = Integer.toOctalString(num);
        System.out.println("Octal Value is : " + octal);
        String binary = Integer.toBinaryString(num);
        System.out.println("Binary Value is : " + binary);
    }

    public static void main(String args[])
    {
 String[] test={"128","56","29"};
 for(int i=0;i<test.length;i++){
     DecimalToBina(test[i]);
 }
    }
}
