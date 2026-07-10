package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utilities.WaitUtility;

public class DashboardPage {

    WebDriver driver;
    WaitUtility wait;
    
    // Locators
    By lblDashboard = By.xpath("//h6[text()='Dashboard']");
    By imgProfile = By.className("oxd-userdropdown-img");
    By lnkLogout = By.linkText("Logout");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtility(driver);
    }

    // Verify Dashboard
    public boolean isDashboardDisplayed() {

        return wait.waitForElement(lblDashboard).isDisplayed();

    }

    // Click Profile
    public void clickProfile() {

        wait.waitForClickable(imgProfile).click();

    }

    // Click Logout
    public void clickLogout() {

        wait.waitForClickable(lnkLogout).click();

    }

    // Complete Logout
    public void logout() {

        wait.waitForClickable(imgProfile).click();

        wait.waitForClickable(lnkLogout).click();
    }
}