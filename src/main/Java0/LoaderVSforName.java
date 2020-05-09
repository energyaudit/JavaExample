package main.Java0;

/**
 * because for same MyExampleClass, Class.forName() is intializing and  printing static block content while ClassLoader.getSystemClassLoader().loadClass() will only load the class and not initialize that’s why not printing anything in console.
 */

public class LoaderVSforName {

    public static void main(String[] args) {
        try {
            System.out.println("==========Result of Class.forName()===========");
            Class.forName("main.Java0.MyClass");

            System.out.println("==========Result of ClassLoader.getSystemClassLoader().loadClass()===========");
            ClassLoader.getSystemClassLoader().loadClass("main.Java0.MyClass");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
