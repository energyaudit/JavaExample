package myPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./src/main/errorScreenshots/" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
		}
		driver.quit();
	}
}
