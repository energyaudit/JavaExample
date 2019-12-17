package main.Java3.JavaCompleteBeginner;


import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;


public class ReadingFils {

    public static void main(String[] args) throws FileNotFoundException {
        //String fileName = "C:/Users/John/Desktop/example.txt";
        String fileName = "src/main/TESTRESULT/example.txt";

        File textFile = new File(fileName);

        Scanner in = new Scanner(textFile);

        int value = in.nextInt();
        System.out.println("Read value: " + value);

        in.nextLine();

        int count = 2;
        while(in.hasNextLine()) {
            String line = in.nextLine();

            System.out.println(count + ": " + line);
            count++;
        }

        in.close();
    }

}