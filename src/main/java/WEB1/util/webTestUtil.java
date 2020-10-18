package WEB1.util;
/**
 * Created by byang on 2016-08-28.
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class webTestUtil {
    public static boolean dropdownOptionVerify(WebElement dropdown,String a) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        for (WebElement we:options) {
            System.out.println("current verify drop down option: "+we.getText());
            if (we.getText().contains(a)) {
                return true;
            }
        }
        return false;
    }

}
