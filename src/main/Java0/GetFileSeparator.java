package main.Java0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetFileSeparator {

    public static void main(String[] args) {

        // unix / , windows \
        String separator = System.getProperty("file.separator");
        System.out.println(separator);

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void whenCheckPathSeparator_thenResultIsAsExpectedOnWindows() throws IOException {
        assertEquals(";", File.pathSeparator);
        assertEquals(';', File.pathSeparatorChar);
    }
}
