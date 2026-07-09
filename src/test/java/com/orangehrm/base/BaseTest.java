package com.orangehrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");

    	driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ConfigReader config = new ConfigReader();
        driver.get(config.getProperty("url"));
      
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}