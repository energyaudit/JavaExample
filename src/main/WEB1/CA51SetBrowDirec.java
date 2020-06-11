package WEB1;

import WEB1.util.PropertyUtil;
import WEB1.util.TestConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class CA51SetBrowDirec {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        String getbrowser=PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        String[] getbrowser={"chrome","firefox"};
        String getbrowser="chrome";
//        for (int i=0; i <2; i++){
            switch(getbrowser){//switch on string
                case "chrome":
                   // System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
            }
        }
//        }




    @Test
    public void testUntitledTestCase() throws Exception {
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
        driver.get("http://www.51.ca/");
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
