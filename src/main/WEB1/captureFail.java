package main.WEB1;

import main.WEB1.util.CaptureFailScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class captureFail extends CaptureFailScreenshot {

    @Test
    //Tests google calculator
    public void googleCalculator() throws IOException {

        //Launch google
        getWebDriver().get("http://www.google.ca");

        //Write 2+2 in google textbox
        WebElement googleTextBox = getWebDriver().findElement(By.id("lst-ib"));
        googleTextBox.sendKeys("2+2");

        //Hit enter
        googleTextBox.sendKeys(Keys.ENTER);

        //Get result from calculator
        WebElement calculatorTextBox = getWebDriver().findElement(By.id("cwtltblr"));
        String result = calculatorTextBox.getText();

        //Intentionaly checking for wrong calculation of 2+2=5 in order to take screenshot for failing test
        Assert.assertEquals(result, "5");
    }
}
