package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EntertainmentTabPage;
import pages.HomePage;

public class Test_EntertainmentTab extends BaseTest {

    EntertainmentTabPage ent;

    @BeforeMethod
    public void navigateToEntertainmentTab () throws InterruptedException {
        ent = new HomePage ().goToEntertainmentTab ();
    }


    @Test
    public void verifyingEntertainmentTabISSelected () throws InterruptedException {
        boolean flag =(ent.EntertainmentTabSelected ());
        Assert.assertTrue (flag);

    }


}
