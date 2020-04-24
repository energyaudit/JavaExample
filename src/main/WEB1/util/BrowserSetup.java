package WEB1.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

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
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                break;
            case "windows":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
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
//                System.setProperty("webdriver.opera.driver", "C:\\QA INSTALL\\operadriver.exe");
                ChromSetProperty(os);
                OperaOptions options = new OperaOptions();
                options.setBinary(new File("C:\\Program Files (x86)\\Opera\\58.0.3135.132\\opera.exe"));
              driver = new OperaDriver(options);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
        }
        return driver;
    }
}
