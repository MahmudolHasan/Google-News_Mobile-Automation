package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import utils.TakeScreenShot;

public class AllureListener implements ITestListener {

	@Override
	public  void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			saveFailedScreenshot(result);
		}
	}

	@Attachment
	public static void saveFailedScreenshot(ITestResult result) {
		TakeScreenShot.takeFailedScreenShot(result);
	}
}
