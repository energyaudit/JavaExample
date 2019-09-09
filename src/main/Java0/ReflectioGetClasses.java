package src.main.Java0;


import java.io.Serializable;
import java.util.Arrays;

public class ReflectioGetClasses {

    public static void main(String... args) {
        Class<?>[] classes = ReflectioGetClasses.class.getClasses();
        Arrays.stream(classes)
                .forEach(System.out::println);
    }

    public class MyClass extends MyClass2 implements Cloneable {
    }

    public class MyClass2 implements Serializable {

    }

    public interface MyInterface extends Serializable {
    }

    public static class MyStaticClass {
    }

    public static class MyMainSuperClass {

    }
}
