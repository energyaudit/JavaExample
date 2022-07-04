package main.Java2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesWalkPattern {

    public static void main(String[] args) {


        // File names for a pattern.
        try (Stream<Path> filesWalk = Files.walk(Paths.get("./src/main/java2/"))) {

            List<String> result = filesWalk.filter(path -> path.toString().contains("Match")).map(x -> x.toString())
                    .collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}