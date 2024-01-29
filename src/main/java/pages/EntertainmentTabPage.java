package pages;

import org.openqa.selenium.By;
import utils.WebUtils;

public class EntertainmentTabPage extends WebUtils {
    By entertainmentTab = By.xpath ("//android.widget.LinearLayout[@content-desc=\"Entertainment\"]");
    public boolean EntertainmentTabSelected() throws InterruptedException {
        return  Boolean.parseBoolean (getEleAttr (entertainmentTab,"selected"));
    }
}
