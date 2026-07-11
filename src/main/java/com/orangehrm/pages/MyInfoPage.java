package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utilities.WaitUtility;

public class MyInfoPage {

	WebDriver driver;
	WaitUtility wait;

	public MyInfoPage(WebDriver driver) {

		this.driver = driver;
		wait = new WaitUtility(driver);
	}

	// My Info Menu
	By menuMyInfo = By.linkText("My Info");

	// Other Id (2nd input on Personal Details page)
	By txtOtherId = By.xpath("(//input[contains(@class,'oxd-input')])[3]");

	// Save Button (first Save button)
	By btnSave = By.xpath("(//button[@type='submit'])[1]");

	// Success Popup
	By successPopup = By.xpath("//p[text()='Successfully Updated']");

	public void clickMyInfo() {

		wait.waitForClickable(menuMyInfo).click();
	}

	public void updateOtherId(String otherId) {

		WebElement element = wait.waitForElement(txtOtherId);

		element.clear();
		element.sendKeys(otherId);
	}

	public void clickSave() {

		wait.waitForClickable(btnSave).click();
	}

	public boolean isUpdateSuccessful() {

		return wait.waitForElement(successPopup).isDisplayed();
	}
}