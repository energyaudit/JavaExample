package main.TestNG;

import main.util.fileExistManager;
import main.util.fileNoExistException;

import static main.util.fileExistManager.find;

public class TestFileExistException {

    public static void main(String[] args) {
fileExistManager manage = new fileExistManager();
        try {
            find("./src/main/TESTRESULT/vlad1.json");
        } catch (fileNoExistException ex) {
            System.err.print(ex);
        }
    }
}