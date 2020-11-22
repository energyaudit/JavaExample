package main.WEB1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WEB1.util.BrowserSetup;

public class ScrollDownExp {

    public static void main(String[] args) {

        WebDriver driver=new BrowserSetup().Setup("chrome","windows");
//        WebDriver  driver=new BrowserSetup().Setup("chrome","mac");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("SoftwareTestingHelp");
        element.sendKeys(Keys.ENTER);
        js.executeScript("window.scrollBy(0,3000)");
       // driver.quit();
    }

}

