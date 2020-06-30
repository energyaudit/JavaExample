package WEB1;

import WEB1.util.BrowserSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;

public class callBrowserSetup {
   private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

//    @BeforeClass
//    public static void setupClass() {
//        WebDriverManager.edgedriver().setup();
//    }

    @Test
    public void testCA51BrowserSetup() throws Exception {
       driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();

//        String getbrowser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("51CA  "+getbrowser+"success");
    }
    @Test
    public void firefoxCA51BrowserSetup() throws Exception {
        driver=new BrowserSetup().Setup("firefox","windows");
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();

//        String getbrowser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("51CA  "+getbrowser+"success");
    }

    @Test
    public void EdgeCA51BrowserSetup() throws Exception {
        driver=new BrowserSetup().Setup("edge","windows");

        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();

    }
    @Test
    public void OperaCA51BrowserSetup() throws Exception {
        driver=new BrowserSetup().Setup("opera","windows");
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
