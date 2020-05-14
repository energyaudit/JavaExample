package main.TestNG;

import static main.util.FilePermit.setFilePermit;

public class CallFilePermit {
    public static void main(String args[]){
        setFilePermit("src/main/TESTRESULT/temp6.json",false,true,false);
    }
}
