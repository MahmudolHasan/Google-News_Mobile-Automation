package pages;

import org.openqa.selenium.By;
import utils.WebUtils;

public class FollowingPage extends WebUtils {

    By headerBarTitle = By.id ("com.google.android.apps.magazines:id/header_bar_title");
    By librarySection = By.xpath ("(//android.widget.ImageView[@resource-id=\"com.google.android.apps.magazines:id/rect_icon\"])[1]");
    By followTopic = By.xpath ("//android.widget.TextView[@resource-id='com.google.android.apps.magazines:id/button' and @text='Follow topics']");
    By signInPrompt = By.id ("com.google.android.apps.magazines:id/sign_in_upsell_dialog_text");


    public String getTitle() throws InterruptedException {
        return getEleAttr (headerBarTitle,"text");
    }
    public String followTopicsAvailability() throws InterruptedException {
        clickOnEle (librarySection);
        clickOnEle (followTopic);
        threadSleep (2);
        return getEleAttr (signInPrompt,"text");

    }
}
