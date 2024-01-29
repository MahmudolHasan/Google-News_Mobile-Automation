package driverFactory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverSetup {

    private static final ThreadLocal<AndroidDriver> LocalDriver = new ThreadLocal<> ();

    public static synchronized void setLocalDriver(AndroidDriver driver){
        if(driver != null) {
            LocalDriver.set (driver);
        }
        System.out.println ("setDriver is called.");
    }

    public static synchronized AndroidDriver getLocalDriver(){
        AndroidDriver driver = LocalDriver.get ();
        if (driver != null )
        {
            System.out.println ("returning driver");
            return  LocalDriver.get ();
        }
        System.out.println ("LocalDriver is empty!");
        return null;

    }

    public static AndroidDriver createDriver(URL url,DesiredCapabilities caps){

        return new AndroidDriver (url,caps);
    }






//    @BeforeSuite
//    public static synchronized void openServer (){
//        DesiredCapabilities caps = new DesiredCapabilities ();
//        caps.setCapability ("platformName", "android");
//        //caps.setCapability ("enforceXPath1", true);
//        caps.setCapability ("automationName", "uiAutomator2");
//        caps.setCapability ("deviceName", "local");
//        caps.setCapability ("udid", "emulator-5554");
//        caps.setCapability ("appPackage", "com.swaglabsmobileapp");
//        caps.setCapability ("appActivity", "com.swaglabsmobileapp.MainActivity");
//
//
//        try{
//                DriverSetup.startAppiumServer ();
//                AndroidDriver driver = createDriver (AppiumServer.getUrl (),caps);
//                LocalDriver.set (driver);
//        } catch (Exception e) {
//            System.out.println ("Problem in BeforeSuite!");
//            throw new RuntimeException (e);
//        }
//
//    }
//
//    @AfterSuite
//    public static synchronized void teardown(){
//        if(LocalDriver.get () != null)
//        {
//            LocalDriver.get ().quit ();
//            AppiumServer.stop ();
//        }
//
//    }


}