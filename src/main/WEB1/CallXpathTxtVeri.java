package main.WEB1;

import WEB1.util.*;
import WEB1.util.OutPutResult;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class CallXpathTxtVeri {
    private static WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    // @Before


    @Test
    public void CallXpathTxt() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
//        driver.get(PropertyUtil.getMessageForApplication(TestConstants.BASE_URL));
//        List<WebElement> webElements = driver.findElements(By.xpath("//*[@id="mainmenu"]/ul/li[9]/a"));//Put whole second column of table to
//        //list webElements,then check if Birthday is inside
//
//        String expect = "Birthday";
//        boolean exist = false;
//        for(WebElement element : webElements){
//            System.out.println(element.getText());
//            if(expect.equals(element.getText())){
//                exist = true;
//            }
//        }
        XpathTxt xpt = new XpathTxt();
        boolean result = XpathTxt.inputStr(driver, "//*[@id=\"mainmenu\"]/ul/li[9]/a", "工作");
        System.out.println(result);

    }

    @Test
    public void findXpathByOrAnd() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://accounts.lambdatest.com/register");
        //Finding the organization field via xpath using OR
        driver.findElement(By.xpath("//input[@name='organization_name' or @placeholder='Organization/Company Name']")).sendKeys("Lambdatest");

        //Finding the full name field via xpath using AND
        driver.findElement(By.xpath("//input[@name='name' and @placeholder='Full Name*']")).sendKeys("Lambdatest");

        //Finding the work email field via xpath using OR, where only one of the attribute defined is correct whereas the other incorrect and does not match, still this should work as one of them meets the condition.
        driver.findElement(By.xpath("//input[@name='email' or @id='not present']")).sendKeys("Lambdatest");

        //Finding the password field via xpath using AND, where only one of the attribute defined is correct whereas
        // the other incorrect and does not match,this should NOT work as one of them does not meets the condition.
        driver.findElement(By.xpath("//input[@name='password' and @id='not present']")).sendKeys("Lambdatest");
        driver.close();
    }

    @Test
    public void findXpathContains() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com");
        //This approach in creating XPath in Selenium comes handy when we have part of attribute values that changes
        // dynamically,<input type="text" placeholder="Organization/Company Name" name="organization_name" value="" class="form-control sign-up-input-2 ">
        //Xpath=//*[contains (@placeholder, ‘Organization)]//Xpath= //input[contains (@name, ‘organization)]
        //Xpath=//*[contains(@class, ‘sign-up-input)],Here in the above XPath example for Selenium we have used,
        // attributes like placeholder,name etc and consider partial values to identify elements using contains keyword
        //click start free testing button
        driver.findElement(By.xpath("//a[contains(text(), 'Testing')]")).click();
        driver.close();
    }

    @Test
    public void findXpathStartwith() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com");
        //Finding the element 'Start testing' having text as same, here we will locate element using contains through xpath
        //This is useful when partly values changes for a given attribute
        driver.findElement(By.xpath("//a[starts-with(text(), 'Start')]")).click();
        driver.close();
    }

    @Test
    public void findXpathByText() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com/blog");
        //Text()
        //This keyword is used to create expressions for XPath in Selenium when we have a text defined in an HTML tag and
        // we wish to identify element via text. This comes really handy when the other attribute values change
        // dynamically with no substantial part of the attribute value that can be used via Starts-with or Contains
        driver.findElement(By.xpath("//a[text()='Running Your First Test With NightWatchJS']")).click();
        driver.close();
    }

    @Test
    public void findXpathByChainXpath() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com/blog");
        // chained xpath
//        <ul class="nav navbar-nav navbar-right">
//<li><a href="https://www.lambdatest.com/feature">Live</a></li>
//<li><a href="https://www.lambdatest.com/selenium-automation">Automation</a></li> <li><a href="https://www.lambdatest.com/blog">Blog</a></li>
// <li><a href="https://www.lambdatest.com/pricing">Pricing</a></li>
//  <li><a href="https://www.lambdatest.com/support/">Support</a></li>
//  <li class="sign-in"><a href="https://accounts.lambdatest.com/login">login</a></li>
// <li class="login"><a href="https://accounts.lambdatest.com/register">Free Sign Up</a>
        String chainXpathLocator = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[@class='login']")).getText();
        System.out.println(chainXpathLocator);
    }

    @Test
    public void findXpathAxes() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com/");
        driver.manage().window().maximize();
        WebElement resource = driver.findElement(By.xpath("//a[.='Resources ']"));
        Actions action = new Actions(driver);
        action.moveToElement(resource).perform();
        //Locate element with the link blog using following axes
        //<ul class="navbar-nav" xpath="1">
        //				         //					  <li class="nav-item dropdown rs-dropdown show">
        //				        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)" style="" aria-expanded="true">Resources <i class="arrow down"></i></a>
        //						<div class="dropdown-menu show" aria-labelledby="dropdownMenuButton">
        //							<a class="dropdown-item" href="https://www.lambdatest.com/blog" style="">Blog</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/certifications/selenium-101">Certifications</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/learning-hub/">Learning Hub</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/webinar/">Webinar</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/newsletter/">Newsletter</a>
        //							<a class="dropdown-item" href="https://community.lambdatest.com/" target="_blank">Community</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/customers/">Case Study</a>
        //							<a class="dropdown-item" href="https://www.lambdatest.com/blog/category/lambdatest-updates/">Product Updates</a>
        //                          </div>
        //				    </ul>
        driver.findElement(By.xpath("(//ul[@class='navbar-nav']//following::li[4])[1]")).click();
        driver.close();
    }
    @Test
    public void findXpathAllSibling() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com/");
        //This is one concept that people tend to get confused with. All you get to clear yourself with this concept,
        // is siblings.
        List<WebElement> webElements = driver.findElements(By.xpath("//li[@class='nav-item']//following-sibling::li"));
        ArrayList<String> obtainedList = new ArrayList<>();
//        ArrayList<String> obtainedList=null;
        for (WebElement we : webElements) {
            obtainedList.add(we.getText());
        }
        System.out.println(obtainedList);
        driver.close();
    }
    @Test
    public void findXpathPecedingSibling() throws Exception {
        driver = new BrowserSetup().Setup("chrome", "windows");
//        driver=new WEB1.util.BrowserSetup().Setup("chrome","mac");
        driver.get("https://www.lambdatest.com/");
        // Preceding-Sibling: So, in this case, you will switch from the context node been a child and move to the preceding
        // sibling node. The pre-condition is Both the child will share the same parent.or not it will not works.
        WebElement webElement = driver.findElement(By.xpath("//a[.='Resources ']//preceding::li[1]"));
        System.out.println(webElement.getText());
        //following method find same sibling
        WebElement webElement1 = driver.findElement(By.xpath("//a[text()='Blog']//preceding::li[1]"));
        System.out.println(webElement1.getText());
        driver.close();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
