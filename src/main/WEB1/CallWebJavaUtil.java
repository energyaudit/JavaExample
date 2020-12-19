package main.WEB1;

import WEB1.util.BrowserSetup;
import WEB1.util.OutPutResult;
import WEB1.util.PropertyUtil;
import WEB1.util.TestConstants;
import main.util.JavaUtil;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;




        import WEB1.util.BrowserSetup;
        import WEB1.util.OutPutResult;
        import WEB1.util.PropertyUtil;

        import WEB1.util.TestConstants;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

        import static org.junit.Assert.fail;

public class CallWebJavaUtil {
    private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    // @Before


    @Test
    public void testCA51TemplateSetup() throws Exception {
//        driver=new BrowserSetup().Setup("chrome","windows");
        driver=new BrowserSetup().Setup("chrome","mac");
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
//         driver.findElement(By.linkText("World")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Millions of Brits warned to renew passports'])[1]/following::h2[2]")).click();

//        String getbrowser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);
//        OutPutResult outR = new OutPutResult();
//        outR.inputStr("CNN  "+getbrowser+"success");
    }
    @Test
    public void getSelectAllOptions() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        //Selecting the multi-select element by locating its id
        Select select = new Select(driver.findElement(By.id("cars")));
        //Get the list of all the options
        System.out.println("The dropdown options are -");
        List<WebElement> options = select.getOptions();
        for(WebElement option: options)
            System.out.println(option.getText());

        //Using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else eit
        if(select.isMultiple()){
            //Selecting option as 'Opel'-- ByIndex
            System.out.println("Select option Opel by Index");
            select.selectByIndex(2);
            //Selecting the option as 'Saab'-- ByValue
            System.out.println("Select option saab by Value");
            select.selectByValue("saab");
            // Selecting the option by text
            System.out.println("Select option Audi by Text");
            select.selectByVisibleText("Audi");
            //Get the list of selected options
            System.out.println("The selected values in the dropdown options are -");
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            for(WebElement selectedOption: selectedOptions)
                System.out.println(selectedOption.getText());
            // Deselect the value "Audi" by Index
            System.out.println("DeSelect option Audi by Index");
            select.deselectByIndex(3);
            //Deselect the value "Opel" by visible text
            System.out.println("Select option Opel by Text");
            select.deselectByVisibleText("Opel");
            //Validate that both the values are deselected
            System.out.println("The selected values after deselect in the dropdown options are -");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());

            //Step#8- Deselect all values
            select.deselectAll();
        }

        driver.quit();
    }
    @Test
    public void CallGetSelectAllOptions() throws Exception {
        driver=new BrowserSetup().Setup("chrome","windows");
//        driver=new BrowserSetup().Setup("chrome","mac");
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Select select = new Select(driver.findElement(By.id("cars")));
        JavaUtil jul = new JavaUtil();
        ArrayList<String> allOtions=jul.getSelectAllOptions(select);
        System.out.println(allOtions);
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
