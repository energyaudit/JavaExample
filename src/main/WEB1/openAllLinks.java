package main.WEB1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class openAllLinks {


    public static void main(String[] args) {
        WebDriver driver;
        driver=new WEB1.util.BrowserSetup().Setup("chrome","windows");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com/");
        java.util.List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println(link.size());

        for (WebElement link2: link) {

            //print the links i.e. http://google.com or https://www.gmail.com
            System.out.println(link2.getAttribute("href"));

            //print the links text
            System.out.println(link2.getText());
        }
    }
}
