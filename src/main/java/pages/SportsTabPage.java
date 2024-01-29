package pages;

import org.openqa.selenium.By;
import utils.WebUtils;

public class SportsTabPage extends WebUtils {

    By sportsTab = By.xpath ("//android.widget.TextView[@text=\"Sports\"]");

    public boolean sportsTabSelected() throws InterruptedException {
        return Boolean.parseBoolean (getEleAttr (sportsTab,"selected"));
    }

}
