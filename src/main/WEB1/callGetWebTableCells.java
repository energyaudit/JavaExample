package main.WEB1;

import WEB1.util.BrowserSetup;
import main.WEB1.util.BrowserSetupHeadless;
import main.WEB1.util.getWebTableCells;
import main.WEB1.util.getWebTableColumn;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class callGetWebTableCells {
   private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private List<WebElement> gwtc;

//    @BeforeClass
//    public static void setupClass() {
//        WebDriverManager.edgedriver().setup();
//    }

    @Test
    public void getTableCellValTest() throws Exception {
       driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        gwtc=new getWebTableCells().getTableCells(driver,"/html/body/table/tbody");
    }
    @Test
    public void getTableFritColumnTest() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
        List<WebElement> firstCells = table.findElements(By.xpath(".//tr/td[1]"));
                System.out.println(firstCells.get(3).getText());
    }
    @Test
    public void getTableFritColumnByCallMethodTest() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
        gwtc=new getWebTableColumn().getTableColumnCells(driver, "/html/body/table/tbody",1);
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
