package main.WEB1;



import WEB1.util.BrowserSetup;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import static main.util.arraylistToArray.ArrayListToArray;

import static org.junit.Assert.fail;

public class watchweight {
    private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    // @Before


    @Test
    public void watchweight() throws Exception {
//       driver=new BrowserSetup().Setup("chrome","windows");
        driver=new BrowserSetup().Setup("chrome","mac");

        driver.get(" https://www.weightwatchers.com/us/");
        driver.findElement(By.linkText("Find a Workshop")).click();
        driver.findElement(By.id("meetingSearch")).sendKeys("10011");
        driver.findElement(By.id("meetingSearch")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//a[@href='https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny']").
        driver.get("https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny");
//        WebElement element=driver.findElement(By.xpath("//span[text()='WW Studio Flatiron']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);
//        element.click();
        List<WebElement> bakeries = driver.findElements(By.className("schedule-detailed-day"));

      ArrayList<String> ar = new ArrayList<String>();
        for (WebElement webElement : bakeries) {
            String name = webElement.getText();
            ar.add(name);
        }
        System.out.println(ar);
    }
    ArrayListToArray(ar);
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
