package src.main.Java2;


import java.io.File;

// Displaying file property
class FileCreate
{
    public static void main(String[] args) {
        //accept file name or directory name through command line args
        String fname ="src/main/TESTRESULT/file.txt";
        String fname1 ="src/main/TESTRESULT/temp.json";
        //pass the filename or directory name to File object
        File f = new File(fname);
        File f1 = new File(fname1);
        //apply File class methods on File object
        System.out.println("File name :"+f.getName());
        System.out.println("Path: "+f.getPath());
        System.out.println("Absolute path:" +f.getAbsolutePath());
        System.out.println("Parent:"+f.getParent());
        System.out.println("Exists :"+f.exists());
        if(f.exists())
        {
            System.out.println("Is writeable:"+f.canWrite());
            System.out.println("Is readable"+f.canRead());
            System.out.println("Is a directory:"+f.isDirectory());
            System.out.println("File Size in bytes "+f.length());
        }

        System.out.println("File name :"+f1.getName());
        System.out.println("Path: "+f1.getPath());
        System.out.println("Absolute path:" +f1.getAbsolutePath());
        System.out.println("Parent:"+f1.getParent());
        System.out.println("Exists :"+f1.exists());
        if(f1.exists())
        {
            System.out.println("Is writeable:"+f1.canWrite());
            System.out.println("Is readable"+f1.canRead());
            System.out.println("Is a directory:"+f1.isDirectory());
            System.out.println("File Size in bytes "+f1.length());
        }
    }
}