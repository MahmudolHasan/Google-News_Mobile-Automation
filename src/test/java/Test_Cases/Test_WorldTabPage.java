package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WorldTabFirstNews;
import pages.worldTabPage;
import utils.AllureListener;

@Listeners(AllureListener.class)
public class Test_WorldTabPage extends  BaseTest{

    worldTabPage wpage;
    WorldTabFirstNews fnews;
    @BeforeMethod
    public void navigateToWorldTab() throws InterruptedException {
        wpage = new HomePage ().goToWorldTab ();
    }

    @Test
    public void verifyingWorldTabIsSelected() throws InterruptedException {
        String  status =wpage.worldTabSelected ();
        Assert.assertEquals (status,"true","World Tab is not selected!");
    }




}
