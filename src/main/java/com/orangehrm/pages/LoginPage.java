package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	WaitUtility wait;

	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.cssSelector("button[type='submit']");
	By lblInvalidCredentials = By.xpath("//p[text()='Invalid credentials']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtility(driver);
	}

	public void enterUsername(String username) {

		wait.waitForElement(txtUsername).sendKeys(username);

	}

	public void enterPassword(String password) {

		wait.waitForElement(txtPassword).sendKeys(password);

	}

	public void clickLogin() {

		wait.waitForClickable(btnLogin).click();

	}

	public boolean isLoginPageDisplayed() {

		return wait.waitForElement(txtUsername).isDisplayed();

	}

	public String getErrorMessage() {

		return wait.waitForElement(lblInvalidCredentials).getText();

	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
}