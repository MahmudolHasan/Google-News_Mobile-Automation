package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebUtils;

import java.util.ArrayList;
import java.util.List;

public class ForYouPage extends WebUtils {
    By forYouSection = By.xpath ("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.magazines:id/tab_for_you\"]/android.widget.ImageView");
    By newsPreferenceOption = By.xpath ("//android.widget.ListView[@resource-id=\"com.google.android.apps.magazines:id/recycler_view\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By signInBtn = By.xpath ("//android.widget.Button[@resource-id=\"com.google.android.apps.magazines:id/primary_action_button\"]");


    public boolean forYouSectionIsSelected () throws InterruptedException {
        return Boolean.parseBoolean (getEleAttr (forYouSection, "selected"));
    }

    public List<String> newsPreferenceOption () throws InterruptedException {
        List<String> optionsNews = new ArrayList<> ();
        List<WebElement> options = findAllElement (newsPreferenceOption);
        for (WebElement ele : options) {
            optionsNews.add (getEleAttr (ele, "text"));
        }
        return optionsNews;
    }

    public boolean visibilityOfSignInButton () throws InterruptedException {
        return elementIsDisplayed (signInBtn);
    }


}

