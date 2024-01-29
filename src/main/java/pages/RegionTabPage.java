package pages;

import org.openqa.selenium.By;

public class RegionTabPage extends worldTabPage {
    By regionTab = By.xpath ("//android.widget.TextView[@text=\"Bangladesh\"]");
    By regionName = By.xpath ("//android.widget.HorizontalScrollView[@resource-id=\"com.google.android.apps.magazines:id/toolbar_tabs\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView");
    By profile = By.xpath ("//android.widget.ImageView[@resource-id=\"com.google.android.apps.magazines:id/og_apd_internal_image_view\"]");
    By newsSettings = By.xpath ("//android.widget.TextView[@resource-id=\"com.google.android.apps.magazines:id/og_text_card_title\" and @text=\"News settings\"]");
    By regionSettings = By.xpath ("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.magazines:id/recycler_view\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]");



    public boolean RegionIsSelected() throws InterruptedException {
        return Boolean.parseBoolean (getEleAttr (regionTab,"selected"));
    }

    public String getRegionName() throws InterruptedException {
        return getEleAttr (regionName,"text");
    }
    public String getRegionNameFromSettings() throws InterruptedException {
        clickOnEle (profile);
        clickOnEle (newsSettings);
        return getEleAttr (regionSettings,"text");
    }

}
