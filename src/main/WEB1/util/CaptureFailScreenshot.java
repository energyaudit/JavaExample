package main.WEB1.util;


import WEB1.util.BrowserSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class CaptureFailScreenshot {
    private WebDriver driver;
    @BeforeTest
    public void setup(){
        driver=new BrowserSetup().Setup("chrome","windows");
    }


    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy-HH-mm-ss");
                   Date date = new Date();
                   String date1= dateFormat.format(date);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("./src/main/errorScreenshots/" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +date1+".jpg"));
        }
        driver.quit();
    }
    public WebDriver getWebDriver(){
        return driver;
    }
}