package com.orangehrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import com.orangehrm.utilities.ScreenshotUtility;
import com.orangehrm.utilities.ConfigReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser, java.lang.reflect.Method method) {

        extent = ExtentManager.getReport();

        test = extent.createTest(method.getName());

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--lang=en-US");

            driver = new ChromeDriver(options);

        }
        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--lang=en-US");

            driver = new FirefoxDriver(options);

        }
        else {

            throw new RuntimeException("Invalid Browser Name");

        }

        driver.manage().window().maximize();

        ConfigReader config = new ConfigReader();

        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.fail("Test Failed");

            ScreenshotUtility.captureScreenshot(driver, result.getName());

        }

        else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed");

        }

        extent.flush();

        driver.quit();

    }
}