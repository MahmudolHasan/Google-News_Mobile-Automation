package pages;

import org.openqa.selenium.By;
import utils.WebUtils;

public class WorldTabFirstNews extends WebUtils {
    By newsTitle = By.xpath ("(//android.widget.LinearLayout[@resource-id=\"com.google.android.apps.magazines:id/card_info\"])[1]/android.widget.TextView[@resource-id=\"com.google.android.apps.magazines:id/title\"]");

    public String getNewsTitle() throws InterruptedException {
        return getEleAttr (newsTitle,"text");
    }
}
