package main.TestNG.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import WEB1.util.BrowserSetup;
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"main.TestNG.steps"})
public class Steps {
    WebDriver driver;
    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable {
//        driver=new BrowserSetup().Setup("firefox","windows");
        driver=new BrowserSetup().Setup("firefox","mac");
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/v4");
    }

    @When("^Enter the Username \"(.*)\" and Password \"(.*)\"$")
    public void enter_the_Username_and_Password(String username, String password) throws Throwable {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable {
        driver.findElement(By.name("btnReset")).click();
        driver.quit();
    }
}


