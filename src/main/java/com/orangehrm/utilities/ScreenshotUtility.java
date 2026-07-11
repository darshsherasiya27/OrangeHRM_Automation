package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static void captureScreenshot(WebDriver driver, String testName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		File dest = new File("Screenshots/" + testName + "_" + timeStamp + ".png");

		try {

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}