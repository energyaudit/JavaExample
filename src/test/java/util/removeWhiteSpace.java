package util;


public class removeWhiteSpace
{
 public  static void removeWhiteSpaceMtd(String str) {
       String str2 = str.replaceAll("\\s", "");
       System.out.println(str2);
   }
    public static void main(String[] args)
    {
        String str1 = "Saket Saurav        is a QualityAna    list";
        removeWhiteSpaceMtd(str1);
        String[] test={"Saket Saurav        is a QualityAna    list","remove all white spaces from a string ","Another string variable str2 is initialized with"};
    for(int i=0;i<test.length;i++){
        removeWhiteSpaceMtd(test[i]);
    }
        //following is remove all vowels by .replaceAll
        String inputString ="Enter the string...";
        String newInputString = inputString.replaceAll("[AEIOUaeiou]", "");
        System.out.println("The string without vowels...");
        System.out.println(newInputString);
    }

}

