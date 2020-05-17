package main.util;

import java.io.File;

public class fileExist {
  static  boolean exist;
    public static boolean fileExistPath(String filepath) {

//Map to JSON

        File file = new File(filepath);
        exist=( file.canExecute()||file.canRead()||file.canWrite());
        if(exist){
            System.out.println("The files exist");
        }else{
            System.out.println("The files DO NOT exist");
        }
        return exist;
    }

    public static void main(String[] args) {
    fileExistPath("./src/main/TESTRESULT/vlad.json") ;
    }
}
