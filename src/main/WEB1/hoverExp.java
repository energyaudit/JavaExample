package main.WEB1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class hoverExp {


    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new WEB1.util.BrowserSetup().Setup("chrome", "windows");
//        WebDriver  driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();

        //Mouseover on submit button
        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("idOfButton"));
        action.moveToElement(btn).perform();

        //Thread.sleep just for user to notice the event
        Thread.sleep(3000);

        //Closing the driver instance
        driver.quit();

    }

}

