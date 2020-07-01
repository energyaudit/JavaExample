package main.WEB1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class CA51ChromeHeadless {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    void setProperty(String  os) {
        switch (os) {
            case "mac":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
                break;
            case "windows":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                break;
        }
    }

    @Before
    public void setUp() throws Exception {

        setProperty("windows");
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.get("http://www.51.ca/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();


    }

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
