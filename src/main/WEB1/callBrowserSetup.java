package main.WEB1;

import WEB1.util.BrowserSetup;
import WEB1.util.BrowserSetupHeadless;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static WEB1.util.scrollDown.ScrollDownPage;
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
    public void chromeCA51BrowserSetup() throws Exception {
       driver=new BrowserSetup().Setup("chrome","windows");
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();
    }
    @Test
    public void HeadlessCA51BrowserSetup() throws Exception {
        driver=new BrowserSetupHeadless().Setup("chrome","windows",true);
//        driver=new BrowserSetupHeadless().Setup("chrome","windows",false);
//       driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();
    }
    @Test
    public void firefoxCA51BrowserSetup() throws Exception {
        driver=new BrowserSetup().Setup("firefox","windows");

        driver.get("http://www.51.ca/");
        driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();

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

    @Test
    public void IECA51BrowserSetup() throws Exception {
        driver=new BrowserSetup().Setup("IE","windows");
        driver.get("http://www.51.ca/");
       // driver.findElement(By.linkText("资讯")).click();
        driver.findElement(By.xpath("//li[@class='li02']//a")).click();
       driver.findElement(By.linkText("新闻精要")).click();
        driver.findElement(By.linkText("51首页")).click();

    }
    @Test
    public void UploadFile() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
        String baseUrl = "http://demo.guru99.com/test/upload/";
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        // enter the file path onto the file-selection input field
        String path=System.getProperty("user.dir");
      String path1=path+"/src/main/resources/source.xlsx";
        uploadElement.sendKeys(path1);
        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();
        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }

    @Test
    public void CallScrollPage() throws Exception {
         driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("SoftwareTestingHelp");
        element.sendKeys(Keys.ENTER);
        ScrollDownPage(driver,600);
    }

    @Test
    public void DeleteInputText() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = "https://www.tutorialspoint.com/index.htm";
        driver.get(url);
            // identify element
        WebElement l = driver.findElement(By.id("gsc-i-id1"));
        // input text
        l.sendKeys("Selenium");
        // sending Ctrl+a by Keys.Chord()
        String s = Keys.chord(Keys.CONTROL, "a");
        l.sendKeys(s);
        // sending DELETE key
        l.sendKeys(Keys.DELETE);
        Thread.sleep(3000);
        l.sendKeys("Selenium second round ");
        l.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Thread.sleep(6000);
    }

    @Test
    public void TestSelectDirectly() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/");
        Thread.sleep(3000);
        WebElement developers_dropdown = driver.findElement(By.id("developers-menu-toggle"));
        Select objSelect = new Select(developers_dropdown);
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        driver.get("https://www.browserstack.com/");
        WebElement solutions_dropdown = driver.findElement(By.id("solutions-menu-dropdown"));
        Select solutions = new Select(solutions_dropdown);
        solutions.selectByValue("4000");
        Thread.sleep(3000);
        WebElement solutions_d = driver.findElement(By.id("solutions-menu-dropdown"));
        Select s1 = new Select(solutions_d);
        s1.selectByVisibleText("Geolocation Testing");
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
