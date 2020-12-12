package WEB1.util;
/**
 * Created by byang on 12/11/2018.
 */
import main.WEB1.util.getWebTableCells;
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
        driver = new BrowserSetup().Setup("chrome", "windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        gwtc = new getWebTableCells().getTableCells(driver, "/html/body/table/tbody");
    }

    @Test
    public void getTableFritColumnTest() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
        List<WebElement> firstCells = table.findElements(By.xpath(".//tr/td[1]"));
        System.out.println(firstCells.get(3).getText());
    }

    @Test
    public void howToFindTableCellXpath() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        //How to write XPath for Table:Step 1 - Set the Parent Element (table), start with "//table". start with "//table".
        //Step 2 - Add the child elements.The element immediately under <table> is <tbody> so we can say that <tbody> is
        // the "child" of <table>,Step 3 - Add Predicates,The <tbody> element contains two <tr> tags.
        //we must first access the second <tr> and not the first. If we simply write "//table/tbody/tr", then we will be
        // accessing the first <tr> tag,Predicates are numbers or HTML attributes enclosed in a pair of square brackets "[ ]"
        // that distinguish a child element from its siblings. Since the <tr> we need to access is the second one, we shall
        // use "[2]" as the predicat
        String baseUrl = "http://demo.guru99.com/test/write-xpath-table.html";
        driver.get(baseUrl);
        String innerText = driver.findElement(
                By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        System.out.println(innerText);
    }

    @Test
    public void HowtoFindNestedTableCellXpath() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        //To access the cell with the text "4-5-6" using the "//parent/child" and predicate concepts
        //we should got : //table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]
        String baseUrl = "http://demo.guru99.com/test/accessing-nested-table.html";
        driver.get(baseUrl);
        String innerText = driver.findElement(
                By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
        System.out.println(innerText);
    }


    @Test
    public void getTableFritColumnByCallMethodTest() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
        gwtc = new getWebTableColumn().getTableColumnCells(driver, "/html/body/table/tbody", 1);
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
