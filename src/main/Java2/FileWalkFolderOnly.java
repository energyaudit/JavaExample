package main.Java2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWalkFolderOnly {

    public static void main(String[] args) {


        System.out.println("Folder names : ");
        try (Stream<Path> filesWalk = Files.walk(Paths.get("./src/main/java2/"))) {

            List<String> result = filesWalk.filter(Files::isDirectory).map(x -> x.toString())
                    .collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}