package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    WebDriver driver;

    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.cssSelector("button[type='submit']");
    By lblInvalidCredentials = By.xpath("//p[text()='Invalid credentials']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }
    public boolean isLoginPageDisplayed() {
        return driver.findElement(txtUsername).isDisplayed();
    }
    public String getErrorMessage() {
        return driver.findElement(lblInvalidCredentials).getText();
    }
    

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}