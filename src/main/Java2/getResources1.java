package main.Java2;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class getResources1 {

    public static void main(String[] args) throws IOException {

        getResources1 app = new getResources1();

        // read all files from a resources folder
        try {

            // files from src/main/resources/json
            List<File> result = app.getAllFilesFromResource("projectname");
            for (File file : result) {
                System.out.println("file : " + file);
                printFile(file);
            }

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

    private List<File> getAllFilesFromResource(String folder)
            throws URISyntaxException, IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(folder);

        // dun walk the root path, we will walk all the classes
        List<File> collect = Files.walk(Paths.get(resource.toURI()))
                .filter(Files::isRegularFile)
                .map(x -> x.toFile())
                .collect(Collectors.toList());

        return collect;
    }

    // print a file
    private static void printFile(File file) {

        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}