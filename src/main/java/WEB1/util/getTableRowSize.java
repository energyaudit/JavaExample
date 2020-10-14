package WEB1.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class getTableRowSize {
    public static int getTableRowSizeMtd(WebDriver wd, WebElement mytable) {
        List<WebElement> rows_table;
        rows_table = mytable.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        System.out.println("The table has total " + rows_count + " rows ");
        return rows_count;
    }
}
