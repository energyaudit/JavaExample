package main.WEB1;

import WEB1.util.BrowserSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class previousTab {
    public static void main(String[] args) throws AWTException {
        WebDriver driver;
               driver=new BrowserSetup().Setup("chrome","windows");
//        driver = new BrowserSetup().Setup("chrome", "mac");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement element1 = driver.findElement(By.name("q"));
        element1.sendKeys("software testing help");
        element1.sendKeys(Keys.ENTER);
        String a = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.partialLinkText("Software Testing Services")).sendKeys(a);
        Robot robot = new Robot(); // instantiated robot class
        robot.keyPress(KeyEvent.VK_CONTROL); // with robot class you can easily achieve anything if you know the shortcut keys
        robot.keyPress(KeyEvent.VK_2); // here, we have just pressed ctrl+2
        robot.keyRelease(KeyEvent.VK_CONTROL); // once we press and release ctrl+2, it will go to the second tab.
        robot.keyRelease(KeyEvent.VK_1); //if you again want to go back to first tab press and release vk_1
        driver.quit();
    }
}