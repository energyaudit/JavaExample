package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestParallel2 {
	public WebDriver driver;

	@DataProvider(parallel=true)
	public Object[][] getData(){
		return new Object[][]{ {"test 1"},
				{"test 2"},
				{"test 3"}
		};
	}


	@Test(dataProvider="getData")
	public void test_01(String value){
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.get("http://www.w3schools.com/");
		driver.findElement(By.xpath("html/body/div[2]/div/a[4]")).click();
		driver.findElement(By.xpath("//*[@id='gsc-i-id1']")).sendKeys(value);


	}
	@AfterMethod
	public void teardownTest (){

		driver.quit();

	}
}
