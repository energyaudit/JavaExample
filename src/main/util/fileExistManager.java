package main.util;

import static main.util.fileExist.fileExistPath;

public class fileExistManager {

    public static void find(String filepath) throws fileNoExistException{
        if(fileExistPath(filepath)){
           System.out.println("File exist, no exception");
        } else {
            throw new fileNoExistException("Could not find file with path:     " + filepath);
        }
    }
}
