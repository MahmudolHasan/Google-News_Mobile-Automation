package utils;



import driverFactory.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//new SimpleDateFormat ("(MM-dd_HH:mm:ss_)").format (Calendar.getInstance ().getTime ()) +
public class TakeScreenShot  {
    public static String  takeFailedScreenShot (ITestResult testResult) {
        AndroidDriver driver = DriverSetup.getLocalDriver ();
        File source = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
        String name = testResult.getTestName ();
        String name2 =testResult.getName ();
        File destination = new File ("src/test/resources/failedScreenShots/"  +  name2 + ".png");
        try {
            FileHandler.copy (source, destination);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    return destination.getPath ();

    }
}
