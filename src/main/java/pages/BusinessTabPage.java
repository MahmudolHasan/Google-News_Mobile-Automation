package pages;

import org.openqa.selenium.By;

public class BusinessTabPage extends worldTabPage {

    By businessTab = By.xpath ("//android.widget.TextView[@text=\"Business\"]");

    public String businessTabSelected() throws InterruptedException {
        return getEleAttr (businessTab,"selected");
    }




}
