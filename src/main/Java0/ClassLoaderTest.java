package main.Java0;

import java.util.ArrayList;

/**
 * Dynamic Class Loading allows the loading of java code that is not known about before a program starts. The Java model loads classes as needed and need not know the name of all classes in a collection before any one of its classes can be loaded and run.
 *
 * For example : Depending on user input you want to create only one object and there are hundreds of classes. Then you don't need load all classes. You can create object at run time by dynamic class loading.
 */
public class ClassLoaderTest extends JavaClassLoader {

    public static void main(String[] args) {

        JavaClassLoader javaClassLoader = new JavaClassLoader();
        javaClassLoader.invokeClassMethod("main.Java0.MyClass", "sayHello");
        javaClassLoader.invokeClassMethod("main.Java0.Employee", "display2");

        System.out.println("Classloader of this class:"
                + ClassLoaderTest.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Log4jClient.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }

    }


