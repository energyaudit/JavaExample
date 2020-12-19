package main.TestNG.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WEB1.util.BrowserSetup;
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"main.TestNG.Login"})
public class Login {
	WebDriver driver;
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
//        driver=new BrowserSetup().Setup("firefox","windows");
		driver=new BrowserSetup().Setup("chrome","windows");
//		driver=new BrowserSetup().Setup("firefox","mac");
		driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/");
		this.driver.close();
	}

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		Thread.sleep(2000);
	  //XPath Locators	Find different elements on web page
		//ID	To find the element by ID of the element
		//Classname	To find the element by Classname of the element
		//Name	To find the element by name of the element
		//Link text	To find the element by text of the link
		//Using Text()
		//This keyword is used to create expressions for XPath in Selenium when we have a text defined in an HTML
		// tag and we wish to identify element via text. This comes really handy when the other attribute values
		// change dynamically with no substantial part of the attribute value that can be used via Starts-with or Contains
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("autotestudemy@mail.com");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Password321!");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		//Contains() is a method used in XPath expression. It is used when the value of any attribute
		// changes dynamically, for example, login information.
		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionButton.isDisplayed());
	}

	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
}
