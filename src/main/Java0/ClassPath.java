package main.Java0;

public class ClassPath {
    public static void main(String[] args) {

        // Get class path by using getProperty static method of System class
        String strClassPath = System.getProperty("java.class.path");

        System.out.println("Classpath is " + strClassPath);

    }
}

