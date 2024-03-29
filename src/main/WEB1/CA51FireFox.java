package WEB1;

import java.util.concurrent.TimeUnit;


import java.util.regex.Pattern;
        import java.util.concurrent.TimeUnit;

import WEB1.util.PropertyUtil;
import WEB1.util.TestConstants;
import org.junit.*;
        import static org.junit.Assert.*;
        import static org.hamcrest.CoreMatchers.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

public class CA51FireFox {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
        driver = new FirefoxDriver();
     //   baseUrl = "https://www.katalon.com/";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
                driver.get("http://www.51.ca/");
                driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();
        driver.navigate().back();
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
