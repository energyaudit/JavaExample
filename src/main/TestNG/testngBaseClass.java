package main.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import WEB1.util.BrowserSetup;
import java.util.concurrent.TimeUnit;

public class testngBaseClass {
	private WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void beforemethod() throws IllegalAccessException{

		driver=new BrowserSetup().Setup("chrome","windows");
		setWebDriver(driver);
		
		
		getWebDriver().manage().window().maximize();
		getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void setWebDriver(WebDriver driver){
		dr.set(driver);
	}
	
	
	public WebDriver getWebDriver(){
		return dr.get();
	}
	
	@AfterMethod
	public void aftermethod(){
		getWebDriver().quit();
		dr.set(null);
	}
}
