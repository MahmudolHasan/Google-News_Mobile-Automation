package Test_Cases;

import driverFactory.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.AppiumServer;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    static final String configFile = "src/test/resources/config.properties";
    static AndroidDriver driver;
    private static boolean appiumFlag;
    private static URL url;


    @BeforeMethod
    public static synchronized void createServer () {
        Properties prop = new Properties ();
        try (FileInputStream fileInputStream = new FileInputStream (configFile)) {
            prop.load (fileInputStream);
        } catch (Exception e) {
            System.out.println ("Error reading configuration file!");
            throw new RuntimeException (e);
        }
        DesiredCapabilities caps = new DesiredCapabilities ();
        caps.setCapability ("platformName", "android");
        caps.setCapability ("automationName", "uiAutomator2");
        caps.setCapability ("deviceName", prop.getProperty ("deviceName"));
        caps.setCapability ("udid", prop.getProperty ("udid"));
        caps.setCapability ("appPackage", prop.getProperty ("appPackage"));
        caps.setCapability ("appActivity", prop.getProperty ("appActivity"));
        try {
            driver = DriverSetup.createDriver (url, caps);

        } catch (SessionNotCreatedException e) {
            System.out.println ("Appium server is not created! Run 'appium` from terminal or set `allure-run = true` in config.properties!");
        } catch (Exception e) {
            System.out.println ("Problem in BeforeMethod!Check script \"BaseTest.java\"");
            throw new RuntimeException (e);
        }

        DriverSetup.setLocalDriver (driver);

    }

    @AfterMethod(alwaysRun = true)
    public static synchronized void teardown () {
        if (driver != null) {
            driver.quit ();
        }
    }

    @BeforeSuite
    public void startAppium () {
        Properties properties = new Properties ();
        try {
            FileInputStream fileInputStream = new FileInputStream (configFile);
            properties.load (fileInputStream);
            appiumFlag = Boolean.parseBoolean (properties.getProperty ("server-run").toLowerCase ());
        } catch (Exception e) {
            System.out.println ("Error in reading the config file in before-suite!");
            throw new RuntimeException (e);
        }
        if (appiumFlag) {
            AppiumServer.start ();
            url = AppiumServer.getUrl ();
        } else {
            try {
                url = new URL (properties.getProperty ("default-url"));
            } catch (MalformedURLException e) {
                System.out.println ("Broken or invalid URL");
                throw new RuntimeException (e);
            }
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeAppium () {
        if (appiumFlag) AppiumServer.stop ();

    }


}
