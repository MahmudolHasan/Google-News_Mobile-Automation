package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SportsTabPage;

public class Test_SportsTab extends BaseTest{
    SportsTabPage sport;

    @BeforeMethod
    public void navigateToBusinessTab () throws InterruptedException {
        sport = new HomePage ().goToSportsTab ();

    }

    @Test
    public void verifyingSportsTabIsSelected() throws InterruptedException {
        Assert.assertTrue (sport.sportsTabSelected ());
    }
}
