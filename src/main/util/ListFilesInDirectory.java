package main.util;

import java.io.File;

public class ListFilesInDirectory {
    public static File[] ListFilesInDirectory(String folderpath) {
        File folder = new File(folderpath);

        File[] files = folder.listFiles();

        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }

    public static void main(String[] args) {
        String[] folder = {"src/main/TESTRESULT", "src/main/resources"};
        for (int i = 0; i < folder.length; i++) {
            ListFilesInDirectory(folder[i]);
        }
    }
}
