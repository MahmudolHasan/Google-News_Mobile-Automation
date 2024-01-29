package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebUtils {
    By latestTab = By.xpath ("//android.widget.TextView[@text=\"Latest\"]");
    By regionTab = By.xpath ("//android.widget.TextView[@text=\"Bangladesh\"]");
    By worldTab = By.xpath ("//android.widget.TextView[@text=\"World\"]");
    By businessTab = By.xpath ("//android.widget.TextView[@text=\"Business\"]");
    By entertainmentTab = By.xpath ("//android.widget.LinearLayout[@content-desc=\"Entertainment\"]");
    By sportsTab = By.xpath ("//android.widget.TextView[@text=\"Sports\"]");
    By headlinesSection = By.xpath ("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.magazines:id/tab_headlines\"]/android.widget.ImageView");
    By title = By.id ("com.google.android.apps.magazines:id/header_bar_title");
    By searchIcon = By.xpath ("//android.widget.ImageView[@content-desc=\"Search\"]");
    By searchInput = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.magazines:id/open_search_view_edit_text\"]");
    By searchSuggest  =  By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.magazines:id/recycler_view\"]");
    By suggestions = By.xpath (
"//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.magazines:id/recycler_view\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    By forYouSection = By.xpath ("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.magazines:id/tab_for_you\"]/android.widget.ImageView");
    By followSuggestion = By.xpath ("(//android.widget.ImageView[@content-desc=\"Follow\"])[1]");
    By requestToSignIn = By.id ("com.google.android.apps.magazines:id/sign_in_upsell_dialog_text");
    By tabsContainer = By.xpath ("//android.widget.HorizontalScrollView[@resource-id=\"com.google.android.apps.magazines:id/toolbar_tabs\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    By moreOption  = By.id ("com.google.android.apps.magazines:id/more_button");
    By moreOptionName =By.xpath ("//android.widget.LinearLayout[@resource-id=\"com.google.android.apps.magazines:id/card_action_menu_container\"]/android.widget.LinearLayout/android.widget.TextView");
    By saveForLater = By.xpath ("//android.widget.TextView[@resource-id=\"com.google.android.apps.magazines:id/text\" and @text=\"Save for later\"]");
    By signInErrorSaveForLater = By.xpath ("//android.widget.FrameLayout[@resource-id=\"com.google.android.apps.magazines:id/custom\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");

    By followPage = By.id("com.google.android.apps.magazines:id/tab_following_text");




    public void numberOfNewsTabs(){

    }
    public Boolean isLatestTabSelected() throws InterruptedException {
        return Boolean.parseBoolean (getEleAttr (latestTab,"selected"));
    }

    public boolean headlineSectionIsSelected() throws InterruptedException {
        return Boolean.parseBoolean (getEleAttr (headlinesSection,"selected"));
    }

    public String getTitle() throws InterruptedException {
        return getEleText (title);
    }

    public boolean searchWith(String keyword) throws InterruptedException {
        clickOnEle (searchIcon);
        textInput (searchInput,keyword);
        return elementIsDisplayed (searchSuggest);
    }

    public List<String> getSearchSuggestions() throws InterruptedException {
        List<String> sgs = new ArrayList<> ();
        List<WebElement> elements= findAllElement (suggestions);
        for(WebElement el:elements){
            sgs.add (getEleText (el));
        }
        return sgs;
    }

    public worldTabPage goToWorldTab() throws InterruptedException {
        clickOnEle (worldTab);
        return new worldTabPage ();
    }

    public RegionTabPage goToRegionTab() throws InterruptedException {
        clickOnEle (regionTab);
        return new RegionTabPage();
    }
    public BusinessTabPage goToBusinessTab() throws InterruptedException {
        clickOnEle (businessTab);
        return new BusinessTabPage();
    }

    public EntertainmentTabPage goToEntertainmentTab() throws InterruptedException {
        clickOnEle (entertainmentTab);
        return new EntertainmentTabPage ();
    }
    public ForYouPage goToForYou() throws InterruptedException {
        clickOnEle (forYouSection);
        return new ForYouPage ();
    }

    public SportsTabPage goToSportsTab() throws InterruptedException {
        //threadSleep (10);
       // scrollUntilVisible (findElement (sportsTab),"right");
        clickOnEle (entertainmentTab);
        clickOnEle (sportsTab);
        return new SportsTabPage();
    }

    public boolean  followTheFirstValidSearchSuggest() throws InterruptedException {
        clickOnEle (followSuggestion);
        return elementIsDisplayed (requestToSignIn);
    }

    public List<String> getTabs() throws InterruptedException {
        List<WebElement> tabs = findAllElement (tabsContainer);
        List<String> tabDetails = new ArrayList<> ();
        for (WebElement ele: tabs){
            tabDetails.add (getEleAttr (ele,"text"));
        }
        clickOnEle (entertainmentTab);
        tabs.clear ();
        tabs = findAllElement (tabsContainer);
        tabDetails.add (getEleAttr (tabs.get (tabs.size ()-1),"text"));
        return tabDetails;
    }

    public boolean moreOptionExistence() throws InterruptedException {
        return elementIsDisplayed (moreOption);
    }

    public List<String> moreOptionsOfFirstNews () throws InterruptedException {
        clickOnEle (moreOption);
        List<WebElement> optionList = findAllElement (moreOptionName);
        List<String> optionNames = new ArrayList<> ();
        for (WebElement ele: optionList){
            optionNames.add (getEleAttr (ele,"text"));
        }
        return optionNames;
    }
    public String saveForLater() throws InterruptedException {
        clickOnEle (moreOption);
        clickOnEle (saveForLater);
        return getEleAttr (signInErrorSaveForLater,"text");
    }

    public FollowingPage goToFollowingPage() throws InterruptedException {
        clickOnEle (followPage);
        return new FollowingPage ();
    }














}
