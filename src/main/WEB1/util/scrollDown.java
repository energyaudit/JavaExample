package main.WEB1.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class scrollDown {
    public static void ScrollDownPage(WebDriver driver, Integer offset){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+offset+")");
    }

}
