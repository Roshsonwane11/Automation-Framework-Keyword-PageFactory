package com.bigbasket.Listeners;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.bigbasket.base.Keyword;
import com.google.common.io.Files;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		File screenshotFile = Keyword.driver.getScreenshotAs(OutputType.FILE);
		File fileLocation = new File(
				System.getProperty("user.dir") + "/target/screenshots/" + result.getName() + ".png");
		try {
			Files.copy(screenshotFile, fileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases Passed: " + result.getName());
	}

}
