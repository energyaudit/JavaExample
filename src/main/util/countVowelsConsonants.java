package main.util;

public class countVowelsConsonants {
    public static Integer countVowel(String str){
        char[]letters=str.toCharArray();
        int count=0;
        for(char c:letters){
            switch(c){
                case'a':
                case'e':
                case'i':
                case'o':
                case'u':
                    count++;
                    break;
                default: // no count increment } }
            }
        }
        System.out.println("Number of vowels in String ["+str+"] is : "+count);
        return count;
    }
    public static void main(String args[]) {
        String input = "Please enter some text";
        Integer Consonants=input.length()-countVowel(input);
        System.out.println("Number of consonants in String ["+input+"] is : "+Consonants);
    }
}