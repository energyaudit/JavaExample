package main.Java0;

public class CommandLineArguments {
    public static void main(String[] args) {
//check to see if the String array is empty
        if (args.length == 0)
        {
            System.out.println("There were no commandline arguments passed!");
        }

        //For each String in the String array
//print out the String.
        for(String argument: args)
        {
            System.out.println(argument);
        }
    }
}
