package main.Java3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by byang on 2/20/2018.
 */
public class StringReguExp {
    public static void main(String args[]){
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)


        System.out.println("by character classes and quantifiers ...");
        System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true
        System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true

        System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)
        System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)
        System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true

        System.out.println("by metacharacters ...");
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true
        System.out.println(Pattern.matches("[789]{1}\\d{9}", "java.util.regex.Matcher"));//false (starts from 3)

        Pattern p = Pattern.compile("t(est)");
        String candidateString = "This is a test. This is another test.";
        Matcher matcher1 = p.matcher(candidateString);
        // Find group number 0 of the first find
        matcher1.find();
        String group_0 = matcher1.group(0);
        String group_1 = matcher1.group(1);
        System.out.println("Group 0 " + group_0);
        System.out.println("Group 1 " + group_1);
        System.out.println(candidateString);

//boolean find()	Return true if match found in the input sequence.
//2	boolean find(int start)	Return true if match found in the input sequence by the starting index.
//        Scanner sc=new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter regex pattern:");
//            Pattern pattern = Pattern.compile(sc.nextLine());
//            System.out.println("Enter text:");
//            Matcher matcher = pattern.matcher(sc.nextLine());
//            boolean found = false;
//            while (matcher.find()) {
//                System.out.println("I found the text "+matcher.group()+" starting at index "+
//                        matcher.start()+" and ending at index "+matcher.end());//Matcher Class − A Matcher object is the engine that interprets the pattern
//                found = true;//and performs match operations against an input string.
//            }
//            if(!found){
//                System.out.println("No match found.");
//            }
//
//
//        }


        ////matcher.find(startindex)
        Pattern p1=Pattern.compile("java");
        Matcher m=p1.matcher("HellojavaHellojava");
        int c=0;
        // finding matching char  BEGIN from character 6
        while(m.find(6))
        {
            c=c+1;
            System.out.println("Start position of matching String (java) "+m.start());
            System.out.println("End position of Matching String (java) "+m.end());
            break;
        }
        System.out.println(" Number of matches : "+c);

    }







    }

