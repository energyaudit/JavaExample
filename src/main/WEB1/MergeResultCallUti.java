package WEB1;

/**
 * Created by byang on 4/23/2018.
 */


import WEB1.util.MergeOut;

import java.io.IOException;

class MergeResultCallUti {
    public static void main(String args[])throws IOException{
//
//        FileInputStream fin=new FileInputStream("C:\\QA\\TESTRESULT\\TestResultl.txt");
//        FileInputStream fin2=new FileInputStream("C:\\QA\\TESTRESULT\\TestResult2.txt");
//        FileInputStream fin3=new FileInputStream("C:\\QA\\TESTRESULT\\temp1.txt");
//        FileInputStream fin4=new FileInputStream("C:\\QA\\TESTRESULT\\member.txt");
//        FileOutputStream fout=new FileOutputStream("C:\\QA\\TESTRESULT\\testout.txt");
MergeOut Mou= new MergeOut();
Mou.inputStr("./src/main/TESTRESULT/TestResultl.txt","./src/main/TESTRESULT/TestResult2.txt","./src/main/TESTRESULT/temp1.txt","./src/main/TESTRESULT/member.txt","./src/main/TESTRESULT/testout.txt");
    }
}

