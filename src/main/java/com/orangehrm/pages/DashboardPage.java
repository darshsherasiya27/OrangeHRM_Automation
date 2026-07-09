package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    // Locators
    By lblDashboard = By.xpath("//h6[text()='Dashboard']");
    By imgProfile = By.className("oxd-userdropdown-img");
    By lnkLogout = By.linkText("Logout");

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify Dashboard
    public boolean isDashboardDisplayed() {
        return driver.findElement(lblDashboard).isDisplayed();
    }

    // Click Profile
    public void clickProfile() {
        driver.findElement(imgProfile).click();
    }

    // Click Logout
    public void clickLogout() {
        driver.findElement(lnkLogout).click();
    }

    // Complete Logout
    public void logout() {
        clickProfile();
        clickLogout();
    }
}