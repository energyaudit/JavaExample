package main.Java0;


import java.util.regex.Matcher;
        import java.util.regex.Pattern;
public class matcherGroup {
    public static void main(String[] args) {
        String regex = "(.*)(\\d+)(.*)";
        String input = "This is a sample Text, 12346, with numbers in between.";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        //Matching the compiled pattern in the String
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
//            group() method of this (Matcher) class returns the matched input subsequence during the last match
            System.out.println("match: "+matcher.group(0));//everything
            System.out.println("First group match: "+matcher.group(1));
            System.out.println("Second group match: "+matcher.group(2));
            System.out.println("Third group match: "+matcher.group(3));
        }
    }
}
