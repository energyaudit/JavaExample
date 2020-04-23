package WEB1;

/**
 * Created by byang on 4/23/2018.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class MergeResult {
    public static void main(String args[])throws IOException{
//creating the FileInputStream objects for all the files
        FileInputStream fin=new FileInputStream("./src/main/TESTRESULT/TestResultl.txt");
        FileInputStream fin2=new FileInputStream("./src/main/TESTRESULT/TestResult2.txt");
        FileInputStream fin3=new FileInputStream("./src/main/TESTRESULT/temp1.txt");
        FileInputStream fin4=new FileInputStream("./src/main/TESTRESULT/temp.txt");
        FileOutputStream fout=new FileOutputStream("./src/main/TESTRESULT/testout.txt");
//creating Vector object to all the stream
        Vector v=new Vector();
        v.add(fin);
        v.add(fin2);
        v.add(fin3);
        v.add(fin4);
//creating enumeration object by calling the elements method
        Enumeration e=v.elements();
        System.out.println("use vector elements to print the variation length output");
//passing the enumeration object in the constructor
        SequenceInputStream bin=new SequenceInputStream(e);
        int i=0;
        while((i=bin.read())!=-1){
            fout.write(i);
            System.out.print((char)i);   }
        bin.close();
        fin.close();
        fin2.close();
        fout.close();
    }   }

