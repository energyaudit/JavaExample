package main.Java2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadListFiles {//list of files can be josn,xml,any file
    private final Logger log = LogManager.getLogger(ReadListFiles.class);
public void ReadListFilesMethod (String fileFolder) throws FileNotFoundException {
    File directoryPath = new File(fileFolder);
    File filesList[] = directoryPath.listFiles();
    log.info("List of files and directories in the specified directory:");
    Scanner sc = null;
    for (File file : filesList) {
        log.info("File name: " + file.getName());
        log.info("File path: " + file.getAbsolutePath());
        log.info("Size :" + file.getTotalSpace());
        sc = new Scanner(file);
        String input;
        StringBuffer sb = new StringBuffer();

        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        System.out.println(sb.toString());
    }
}

    public static void main(String args[]) throws FileNotFoundException {
        ReadListFiles rLf=new ReadListFiles();
        rLf.ReadListFilesMethod("src/main/resources/projectname");

    }
}