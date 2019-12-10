package main.Java3;


import java.util.Objects;

public class NotNull1  {

    public static void main(String... args) {
        String str = null;
        str = Objects.requireNonNull(str);
    }//expect error: Exception in thread "main" java.lang.NullPointerException
}
