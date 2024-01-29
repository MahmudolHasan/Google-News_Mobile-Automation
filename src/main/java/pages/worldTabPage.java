package pages;

import org.openqa.selenium.By;
import utils.WebUtils;

public class worldTabPage extends WebUtils {

    By firstNews = By.xpath ("(//android.widget.LinearLayout[@resource-id=\"com.google.android.apps.magazines:id/card_content\"])[1]/android.widget.LinearLayout[2]/android.widget.TextView");
    By worldTab = By.xpath ("//android.widget.TextView[@text=\"World\"]");

    public WorldTabFirstNews clickOnFirstNews() throws InterruptedException {
        clickOnEle (firstNews);
       return new WorldTabFirstNews ();
    }
    public String getFirstNewsTitle() throws InterruptedException {
        return getEleAttr (firstNews,"text");
    }
    public String worldTabSelected() throws InterruptedException {
        return getEleAttr (worldTab,"selected");
    }

}
