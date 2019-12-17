package main.Java3.JavaCompleteBeginner;


import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileReader;



public class Exception1 {

    public static void main(String[] args) throws FileNotFoundException {
//        public static void main(String[] args) {
        File file = new File("test.txt");

        FileReader fr = new FileReader(file);
    }

}