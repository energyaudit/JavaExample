package WEB1;

import WEB1.util.BrowserSetup;
import WEB1.util.assertFloatByCss;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class VeriFloatCallUti {
   private WebDriver driver;
    private String gasprice;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

   // @Before


    @Test
    public void verifyVariable() throws Exception {
//       driver=new BrowserSetup().Setup("chrome","windows");
        driver=new BrowserSetup().Setup("chrome","mac");
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
        // element is object that cannnot be compare to 0,so get txt attribute then parse back to float
        driver.get("http://www.51.ca/");

        assertFloatByCss vf=new assertFloatByCss();
       boolean  result=vf.inputStr(driver,"li > span.gaspricebox > a",0);
        assertTrue(result);
//        String getbrowser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("51CA  "+getbrowser+" verified gas price >0");
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
