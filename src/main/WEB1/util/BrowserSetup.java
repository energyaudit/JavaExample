package WEB1.util;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BrowserSetup {
    public static WebDriver driver;
    static void ChromSetProperty(String  os) {
        switch (os) {
            case "mac":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
                break;
            case "windows":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                break;
        }
    }
    static void FirefoxSetProperty(String  os) {
        switch (os) {
            case "mac":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
                break;
            case "windows":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                break;
        }
    }
    static void EdgeSetProperty(String  os) {
        switch (os) {
            case "mac":
                System.setProperty("webdriver.edge.driver","./src/main/resources/msedgedriver");
                break;
            case "windows":
                System.setProperty("webdriver.edge.driver","./src/main/resources/msedgedriver.exe");
                break;
        }
    }
    static void OperaSetProperty(String  os) {
        switch (os) {
            case "mac":
                System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver");
                break;
            case "windows":
                System.setProperty("webdriver.opera.driver", "./src/main/resources/operadriver.exe");
                break;
        }
    }
    public static WebDriver Setup(String browser,String os) {
//        String browser = PropertyUtil.getMessageForApplication(TestConstants.BROWSER);

        switch (browser) {//switch on string
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                ChromSetProperty(os);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                 break;
            case "firefox":
//
                FirefoxSetProperty(os);
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "opera":
                OperaSetProperty(os);
//                OperaOptions options = new OperaOptions();
//                options.setBinary(new File("./src/main/resources/operadriver.exe"));
//              driver = new OperaDriver(options);
                driver = new OperaDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "edge":
//                System.setProperty("webdriver.edge.driver","./src/main/resources/msedgedriver.exe");
//                EdgeSetProperty(os);
//                driver = new EdgeDriver();
//                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                ChromeOptions chromeOptions = new ChromeOptions();

                EdgeSetProperty(os);
                EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
                driver = new EdgeDriver(edgeOptions);
                break;
        }
        return driver;
    }
}
