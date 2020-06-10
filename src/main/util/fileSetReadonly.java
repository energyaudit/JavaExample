package main.util;

import java.io.File;

public class fileSetReadonly {
    public static void fileSetReadonly(String filepath){
        File anyTextFile = new File(filepath);
        //making the file as read-only using setReadOnly() method
        boolean result = anyTextFile.setReadOnly();
        if(result)
        {
            System.out.println("File is now read-only...!");
        }
        else
        {
            System.out.println("File is still writable...!");
        }
    }

    public static void main(String[] args)
    {
 String filePath1="src/main/TESTRESULT/vlad.json";
        fileSetReadonly(filePath1);
    }
}
