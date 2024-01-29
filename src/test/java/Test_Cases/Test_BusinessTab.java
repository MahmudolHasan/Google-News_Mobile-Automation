package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BusinessTabPage;
import pages.HomePage;

public class Test_BusinessTab extends BaseTest {

    BusinessTabPage business ;
    @BeforeMethod
    public void navigateToBusinessTab () throws InterruptedException {
        business = new HomePage ().goToBusinessTab ();
    }

    @Test
    public void verifyingBusinessTabIsSelected () throws InterruptedException {
        boolean flag = Boolean.parseBoolean ( business.businessTabSelected ());
}


}
