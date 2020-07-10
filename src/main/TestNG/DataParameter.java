package main.TestNG;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WEB1.util.BrowserSetup;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataParameter {

    WebDriver driver;
    @Test
    @Parameters({"author","searchKey"})
    public void testParameterWithXML( @Optional("billy") String author,@Optional("Toronto")String searchKey) throws InterruptedException{
        driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
//        System.setProperty("webdriver.gecko.driver", "./src/main/resourcesgeckodriver.exe");
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

        WebElement searchText = driver.findElement(By.name("q"));
        //Searching text in google text box
        searchText.sendKeys(searchKey);

        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        System.out.println("Thread will sleep now");
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
        //verifying the value in google search box
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

    }
}
