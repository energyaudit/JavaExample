package main.WEB1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class iframe {
    private WebDriver driver;
    @Test
    public void testCA51BrowserSetup() throws Exception {
        //     driver=new BrowserSetup().Setup("chrome","windows");
        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/guru99home/");
        // navigates to the page consisting an iframe
        driver.manage().window().maximize();
        driver.switchTo().frame("a077aa5e"); //switching the frame by ID
        System.out.println("********We are switch to the iframe*******");
        driver.findElement(By.xpath("html/body/a/img")).click();
        //Clicks the iframe
        System.out.println("*********We are done***************");
    }
}
