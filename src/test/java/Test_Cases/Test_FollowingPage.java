package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FollowingPage;
import pages.HomePage;

public class Test_FollowingPage extends BaseTest {
    FollowingPage follow ;
    @BeforeMethod
    public void navigateToFollowingYouPage () throws InterruptedException {
        follow = new HomePage ().goToFollowingPage ();
    }
    @Test 
    public void validateFollowingPageNavigation() throws InterruptedException {
        String actualTitle = follow.getTitle ();
        String expectedTitle ="Following";
        Assert.assertEquals (actualTitle,expectedTitle);
    }
    @Test
    public void validateFollowTopicFunctionalityWithOutSignIn() throws InterruptedException {
        String actualMessage= follow.followTopicsAvailability ();
        String expectedMessage = "To follow a topic, you need to be signed in";
        Assert.assertEquals (actualMessage,expectedMessage);
    }

}
