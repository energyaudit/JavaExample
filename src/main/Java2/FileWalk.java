package main.Java2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWalk {

    public static void main(String[] args) {

        System.out.println("Files in folder : ");
        try (Stream<Path> filesWalk = Files.walk(Paths.get("."))) {

            List<String> result = filesWalk.filter(Files::isRegularFile).map(x -> x.toString())
                    .collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}