package main.TestNG;

import static main.util.PercentageCharacters.characterPercentage;

public class CallcharaterPercent {
    public static void main(String[] args)
    {
        characterPercentage("Tiger Runs @ The Speed Of 100 km/hour.");
//        characterPercentage("My e-mail : eMail_Address321@anymail.com");
//        characterPercentage("AUS : 123/3, 21.2 Overs");
        String[] test={"My e-mail : eMail_Address321@anymail.com","AUS : 123/3, 21.2 Overs"};
        for(int i=0;i<test.length;i++){
            characterPercentage(test[i]);
        }
    }
}
