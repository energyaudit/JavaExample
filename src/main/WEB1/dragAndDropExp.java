package main.WEB1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class dragAndDropExp {


    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new WEB1.util.BrowserSetup().Setup("chrome", "windows");
//        WebDriver  driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        //Element(BANK) which need to drag.
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //Drag and Drop by Pixel.
        act.dragAndDropBy(From,135, 40).build().perform();

//        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions act1=new Actions(driver);

        //Dragged and dropped.
        act1.dragAndDrop(From1, To).build().perform();
                driver.quit();
    }

}

