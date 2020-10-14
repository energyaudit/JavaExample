package main.WEB1;

import WEB1.util.BrowserSetup;
import org.openqa.selenium.*;


import java.util.concurrent.TimeUnit;

import static WEB1.util.scrollDown.ScrollDownPage;

public class callScrollDown {

    public static void main(String[] args) {

        WebDriver driver=new BrowserSetup().Setup("chrome","windows");
//        WebDriver  driver=new BrowserSetup().Setup("chrome","mac");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("SoftwareTestingHelp");
        element.sendKeys(Keys.ENTER);
        ScrollDownPage(driver,1600);
//        driver.quit();
    }

}

