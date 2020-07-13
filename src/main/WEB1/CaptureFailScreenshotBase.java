package main.WEB1;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import WEB1.util.BrowserSetup;

public class CaptureFailScreenshotBase {
    private WebDriver driver;
    @BeforeTest
    public void setup(){
        driver=new BrowserSetup().Setup("chrome","windows");
    }
    @Test
    public  void captureScreenMethod() throws Exception{

        try{
            driver.get("https://www.softwaretestingmaterial.com");
            driver.navigate().refresh();
            //driver.findElement(By.xpath("//*[@id='cse-search-box']/div/input[4]")).sendKeys("agile"); //Statement with correct Xpath
            driver.findElement(By.xpath("//*[@id='cse']")).sendKeys("agile"); //Statement with incorrect Xpath
        }catch(Exception e){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./src/main/screenshot/SoftwareTestingMaterial.png"));
        }

    }
    @Test
    //Tests google calculator
    public void googleCalculator() throws IOException{

        //Launch google
        driver.get("http://www.google.co.in");

        //Write 2+2 in google textbox
        WebElement googleTextBox = driver.findElement(By.id("lst-ib"));
        googleTextBox.sendKeys("2+2");

        //Hit enter
        googleTextBox.sendKeys(Keys.ENTER);

        //Get result from calculator
        WebElement calculatorTextBox = driver.findElement(By.id("cwtltblr"));
        String result = calculatorTextBox.getText();

        //Intentionaly checking for wrong calculation of 2+2=5 in order to take screenshot for failing test
        Assert.assertEquals(result, "5");
    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./src/main/errorScreenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }

    }
    @AfterTest
    public void teardownTest (){
        driver.quit();

    }
}