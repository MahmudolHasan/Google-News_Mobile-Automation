package Test_Cases;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.AllureListener;

import java.util.ArrayList;
import java.util.List;

@Listeners(AllureListener.class)
public class Test_homePage extends BaseTest {
    HomePage homePage;
    SoftAssert softAssert;

    //
    @Test
    public void verifyingAppOpenedLatestTab () throws InterruptedException {
        homePage = new HomePage ();
        Assert.assertTrue (homePage.isLatestTabSelected ());
    }
    //
    @Test
    public void verifyingAppOpenedWithHeadlinesSection () throws InterruptedException {
        homePage = new HomePage ();
        Assert.assertTrue (homePage.headlineSectionIsSelected ());
    }

    @Test
    public void verifyingPageTitle () throws InterruptedException {
        homePage = new HomePage ();
        String actualTitle = homePage.getTitle ();
        String expectedTitle = "Headlines";
        Assert.assertEquals (actualTitle, expectedTitle, "title didn't match");
    }

    @Test
    public void verifyingSearchSuggestionFeature () throws InterruptedException {
        homePage = new HomePage ();
        boolean flag = homePage.searchWith ("bangladesh");
        Assert.assertTrue (flag, "suggestion is not showed!");
    }

    @Test
    public void verifyingSearchSuggestionsContainKeyWord () throws InterruptedException {
        homePage = new HomePage ();
        softAssert = new SoftAssert ();
        String searchWord = "bangladesh";
        boolean flag = homePage.searchWith (searchWord);

        List<String> texts = homePage.getSearchSuggestions ();
        for (String text : texts) {
            softAssert.assertTrue ((text.toLowerCase ().contains (searchWord.toLowerCase ())));
           // System.out.println (text);
        }
        softAssert.assertAll ();
    }

    @Test
    public void validatingAddingSearchWordToFavouriteTopic () throws InterruptedException {
        homePage = new HomePage ();
        homePage.searchWith ("bangladesh");
        boolean flag = homePage.followTheFirstValidSearchSuggest ();
        Assert.assertTrue (flag,"No popup message to prompt signIn");

    }

    @Test
    public void validatingNumberOfTabs() throws InterruptedException {
        homePage = new HomePage ();
        List<String> tabs = homePage.getTabs ();
        Assert.assertEquals (tabs.size (),6,"All tabs are not present!");
    }

    @Test
    public void verifyingTheTabsName() throws InterruptedException {
        homePage = new HomePage ();
        List<String> tabs = homePage.getTabs ();
        List<String> expectedTabs =  new ArrayList<> (List.of("Latest","Bangladesh","World","Business","Entertainment","Sports"));
        Assert.assertEquals (expectedTabs, tabs);
    }

    @Test
    public void verifyingSaveForLaterFeatureWithoutSignIn() throws InterruptedException {
            homePage = new HomePage ();
            String actualErrorMessage = homePage.saveForLater ();
            Assert.assertEquals (actualErrorMessage,"To save this story, you need to be signed in","No signIn error message displayed");
    }
    @Test
    public void verifyingTheExistenceOfThreeDotMenuForEachNews() throws InterruptedException {
        homePage= new HomePage ();
        Assert.assertTrue (homePage.moreOptionExistence ());
    }
    @Test
    public void verifyingThreeDotMenuOption() throws InterruptedException {
        homePage= new HomePage ();
        List<String> actualNames = homePage.moreOptionsOfFirstNews ();
        List<String> expectedNames =  new ArrayList<> (List.of("Save for later","Share","Go to ","Send feedback"));
        softAssert = new SoftAssert ();
        softAssert.assertEquals (actualNames.size (),4);
        for(int i =0; i<actualNames.size ();i++)
        {
            softAssert.assertTrue (actualNames.get (i).contains(expectedNames.get (i)));
        }
        softAssert.assertAll ();
    }


}
