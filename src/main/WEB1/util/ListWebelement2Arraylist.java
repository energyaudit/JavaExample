package main.WEB1.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListWebelement2Arraylist {
    public static List<String> ListWebelement2ArraylistStr(List<WebElement> listWebElement) {
        ArrayList<String> ar = new ArrayList<String>();
        for (WebElement webElement : listWebElement) {
            String name = webElement.getText();
            ar.add(name);
        }
        System.out.println("The returned string of list is:  " + ar);
        return ar;
    }
}
