package testng;



import org.testng.annotations.Test;

public class TestHomePage extends testngBaseClass {


	@Test
	public void test_01() throws InterruptedException{
		getWebDriver().get("http://www.google.com/");
		Thread.sleep(1000);
	}

}
