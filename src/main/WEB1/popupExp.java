package main.WEB1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class popupExp {


    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new WEB1.util.BrowserSetup().Setup("chrome", "windows");
//        WebDriver  driver=new BrowserSetup().Setup("chrome","mac");
        Path sampleFile = Paths.get("./src/main/resources/seleniumPop.html");
        driver.get(sampleFile.toUri().toString());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        driver.findElement(By.id("PopUp")).click();
        Robot robot = new Robot();
        robot.mouseMove(400, 5);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        driver.quit();

    }

}

