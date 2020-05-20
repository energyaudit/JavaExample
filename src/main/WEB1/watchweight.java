package main.WEB1;



import WEB1.util.BrowserSetup;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import  main.util.arraylistToArray;

import static main.WEB1.util.TitleAssert.titleAssert;
import static main.util.countOccur.countOccurences;
import static main.util.removeLineBreakArray.removeLineBrArray;
import static main.util.take1stWordTreeSet.take1stWordOnlyTreeSet;
import static org.junit.Assert.fail;

public class watchweight {
    private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private ArrayList<String> ar = new ArrayList<String>();

//    public static void main(String args[]) {
//        TreeSet treeSet = new TreeSet();
//        treeSet.add("JOHN B");
//        treeSet.add("JOHN B");
//        treeSet.add("DANA F");
//        treeSet.add("LISA S");
//        treeSet.add("LAUREN C");
//        treeSet.add("ARANSAS S");
//        treeSet.add("CAMI B");
//        treeSet.add("MARIA S");
//        treeSet.add("STEVEN H");
//        treeSet.add("MINDI K");
//        treeSet.add("SILMARA R");
//        treeSet.add("RICARDO M");
//        treeSet.add("ROBERT B");
//    }
    // @Before


    @Test
    public void watchweight() throws Exception {
    //    driver=new BrowserSetup().Setup("chrome","windows");
        driver=new BrowserSetup().Setup("chrome","mac");
        driver.get(" https://www.weightwatchers.com/us/");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
        titleAssert(1,actualTitle,expectedTitle);
        driver.findElement(By.linkText("Find a Workshop")).click();
        String actualTitle2= driver.getTitle();
        System.out.println(actualTitle2);
        String expectedTitle2 = "Find WW Studios & Meetings Near You | WW USA";
        titleAssert(2,actualTitle2,expectedTitle2);
        driver.findElement(By.id("meetingSearch")).sendKeys("10011");
        driver.findElement(By.id("meetingSearch")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//a[@href='https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny']").
        driver.get("https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny");
//        WebElement element=driver.findElement(By.xpath("//span[text()='WW Studio Flatiron']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);
//        element.click();
        List<WebElement> bakeries = driver.findElements(By.className("schedule-detailed-day"));
        for (WebElement webElement : bakeries) {
            String name = webElement.getText();
            ar.add(name);
        }
        System.out.println("list schedule"+ar);
        arraylistToArray week=new arraylistToArray();
        String[] weekTest =week.ArrayListToArray(ar);
        removeLineBrArray(weekTest);
        System.out.println("weekTest.length+weekTest[0]"+weekTest.length+weekTest[0]);
        System.out.println(countOccurences(weekTest[0],"JOHN"));
            System.out.println("after remove line breaker");
        for(int i=0;i<weekTest.length;i++){
            System.out.println(weekTest[i]);
        }
        TreeSet treeSet = new TreeSet();
        //Add objects to the HashSet.
        treeSet.add("JOHN B");
        treeSet.add("DANA F");
        treeSet.add("LISA S");
        treeSet.add("LAUREN C");
        treeSet.add("ARANSAS S");
        treeSet.add("CAMI B");
        treeSet.add("MARIA S");
        treeSet.add("STEVEN H");
        treeSet.add("MINDI K");
        treeSet.add("SILMARA R");
        treeSet.add("RICARDO M");
        treeSet.add("ROBERT B");

       String[] weekTest1 = {"Sun   9:00 AM JOHN B.  10:30 AM JOHN B.  12:00 PM JOHN B", "Mon   8:15 AM DANA F.  12:30 PM LISA S.  6:00 PM LISA S", "Tue   11:15 AM LAUREN C.  12:15 PM LAUREN C.  5:15 PM ARANSAS S.  6:45 PM ARANSAS S", "Wed   10:00 AM CAMI B.  12:15 PM CAMI B.  5:30 PM MARIA S", "Thu   8:15 AM STEVEN H.  9:15 AM STEVEN H.  12:15 PM DIANE M.  5:15 PM MINDI K.  6:15 PM MINDI K", "Fri   8:15 AM SILMARA R.  12:15 PM SILMARA R.  5:30 PM RICARDO M", "Sat   8:30 AM ROBERT B.  10:00 AM ROBERT B.  11:30 AM ROBERT B"};
        List<String> list = take1stWordOnlyTreeSet(treeSet);
//        for (int i = 0; i < weekTest1.length; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                if (countOccurences(weekTest1[i], list.get(j)) != 0) {
//                    System.out.println(weekTest1[i] + ":" + list.get(j) + "::" + countOccurences(weekTest1[i], list.get(j)));
//                }
//            }
//        }
        for (int i = 0; i < weekTest.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (countOccurences(weekTest[i], list.get(j)) != 0) {
                    System.out.println(weekTest[i] + ":" + list.get(j) + "::" + countOccurences(weekTest[i], list.get(j)));
                }
            }
        }



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
