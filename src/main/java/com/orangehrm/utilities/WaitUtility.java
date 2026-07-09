package com.orangehrm.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    WebDriver driver;
    WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public WebElement waitForElement(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

}