package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ForYouPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class Test_ForYouPage extends BaseTest{
    ForYouPage forYou;
    SoftAssert softAssert;

    @BeforeMethod
    public void goToForYouPage () throws InterruptedException {
        forYou = new HomePage ().goToForYou ();
    }

    @Test
    public void isForYouPageSelected () throws InterruptedException {
        softAssert = new SoftAssert ();
        List<String> list = forYou.newsPreferenceOption ();
        softAssert.assertEquals (list.size (),3);
        List<String> expectedList = new ArrayList<> (List.of("Your briefing", "News for you", "Your local news"));
        softAssert.assertTrue (expectedList.containsAll (list));
    }
    @Test
    public void verificationOfSignInButtonWhenUserNotLoggedIn() throws InterruptedException {
        Assert.assertTrue (forYou.visibilityOfSignInButton ());
    }
}
