package WEB1.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class getWebTableColumn {
    //
public static List<WebElement> columnCells;

    public static List<WebElement> getTableColumnCells(WebDriver wd,String tableXpath,Integer column) {
        WebElement table = wd.findElement(By.xpath(tableXpath));
       String columnPath=".//tr/td["+column+"]";
//        List<WebElement> columnCells = table.findElements(By.xpath(".//tr/td[1]"));
          List<WebElement> columnCells = table.findElements(By.xpath(columnPath));
        System.out.println(columnCells.get(3).getText());
        return columnCells;
        }

    }


