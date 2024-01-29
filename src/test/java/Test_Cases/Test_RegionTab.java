package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegionTabPage;

public class Test_RegionTab extends BaseTest{
    RegionTabPage region;
    @BeforeMethod
    public void goToRegionTab() throws InterruptedException {
        region = new HomePage ().goToRegionTab ();
    }
    @Test
    public void verifyingRegionTabIsSelected() throws InterruptedException {
        boolean flag = (region.RegionIsSelected ());
        Assert.assertTrue (flag);

    }
    @Test
    public void verifyingRegionNameWithSettings() throws InterruptedException {
        String tabName  = region.getRegionName ();
        String sName = region.getRegionNameFromSettings ();
        System.out.println (tabName+ "---sname : "+sName);
        Assert.assertTrue (sName.contains (tabName));
    }
}
