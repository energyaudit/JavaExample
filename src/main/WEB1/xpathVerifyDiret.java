package main.WEB1;

import WEB1.util.BrowserSetup;
import WEB1.util.OutPutResult;
import WEB1.util.PropertyUtil;
import WEB1.util.TestConstants;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.fail;

public class xpathVerifyDiret {
   private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

   // @Before


    @Test
    public void FacebookTemplateSetup() throws Exception {
       driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
// how to find xpath, take each word of father to grandpa
        driver.get("http://www.51.ca/");
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@id=\"mainmenu\"]/ul/li[9]/a"));//Put whole second column of table to
        //list webElements,then check if Birthday is inside

        String expect = "工作";
        boolean exist = false;
        for(WebElement element : webElements){
            System.out.println(element.getText());
            String etxt=element.getText();
            if(expect.equals(element.getText())){
                exist = true;
            }
        }
System.out.println(exist);
//        String getbrowser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("Expect txt exist= "+exist+" "+getbrowser);
    }
    @Test
    public void xpathAxes() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        //if the text is changed dynamically,so use its parent which neve changed then child :this is called axe to locate
        driver.get("https://accounts.lambdatest.com/register");
        driver.manage().window().maximize();

        //Finding the work email filed using the child locator xpath axes
        driver.findElement(By.xpath("//div[@class='col-sm-12 google-sign-form']/child::input[3]")).sendKeys("sadhvi singh");;

        driver.close();
    }
    @Test
    public void dragAndDrop() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
  driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions act1=new Actions(driver);

        //Dragged and dropped.
        act1.dragAndDrop(From1, To).build().perform();
    }
    @Test
    public void dragAndDrop1() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        //Element(BANK) which need to drag.
        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        //Element(DEBIT SIDE) on which need to drop.
        WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));
        //Element(SALES) which need to drag.
        WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        //Element(CREDIT SIDE) on which need to drop.
        WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));
        //Element(500) which need to drag.
        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        //Element(DEBIT SIDE) on which need to drop.
        WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));
        //Element(500) which need to drag.
        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        //Element(CREDIT SIDE) on which need to drop.
        WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));
        //Using Action class for drag and drop.
        Actions act=new Actions(driver);
        //BANK drag and drop.
        act.dragAndDrop(From1, To1).build().perform();
        //SALES drag and drop.
        act.dragAndDrop(From2, To2).build().perform();
        //500 drag and drop debit side.
        act.dragAndDrop(From3, To3).build().perform();
        //500 drag and drop credit side.
        act.dragAndDrop(From4, To4).build().perform();
        //Verifying the Perfect! message.
        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())
        {
            System.out.println("Perfect Displayed !!!");
        }
        else
        {
            System.out.println("Perfect not Displayed !!!");
        }
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
