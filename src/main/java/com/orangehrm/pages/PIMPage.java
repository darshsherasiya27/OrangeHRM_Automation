package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.utilities.WaitUtility;

public class PIMPage {

    WebDriver driver;
    WaitUtility wait;
 // PIM Menu
    By menuPIM = By.linkText("PIM");

    // Add Button
    By btnAdd = By.xpath("//button[normalize-space()='Add']");

    // First Name
    By txtFirstName = By.name("firstName");

    // Last Name
    By txtLastName = By.name("lastName");

    // Save Button
    By btnSave = By.xpath("//button[@type='submit']");
 // Employee List Menu
    By menuEmployeeList = By.linkText("Employee List");

    // Employee Name
    By txtEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");

    // Search Button
    By btnSearch = By.xpath("//button[normalize-space()='Search']");
    By suggestion = By.xpath("//div[@role='listbox']//span");
    public PIMPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtility(driver);
    }
    
    public void clickPIM() {

        wait.waitForClickable(menuPIM).click();

    }

    public void clickAdd() {

        wait.waitForClickable(btnAdd).click();

    }

    public void enterFirstName(String firstName) {

        wait.waitForElement(txtFirstName).sendKeys(firstName);

    }

    public void enterLastName(String lastName) {

        wait.waitForElement(txtLastName).sendKeys(lastName);

    }

    public void clickSave() {

        wait.waitForLoaderToDisappear();

        WebElement saveButton = wait.waitForClickable(btnSave);

        try {
            saveButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", saveButton);
        }

        wait.waitForLoaderToDisappear();
    }
    public void clickEmployeeList() {

        wait.waitForClickable(menuEmployeeList).click();

    }

    public void searchEmployee(String employeeName) throws InterruptedException {

        wait.waitForElement(txtEmployeeName).clear();

        wait.waitForElement(txtEmployeeName).sendKeys(employeeName);

        Thread.sleep(2000);

        wait.waitForClickable(suggestion).click();

        wait.waitForClickable(btnSearch).click();

    }
    public boolean isEmployeeDisplayed(String employeeName) {

        By employee = By.xpath("//*[contains(text(),'" + employeeName + "')]");

        return wait.waitForElement(employee).isDisplayed();

    }
    public boolean isPersonalDetailsPageDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        return wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

    }
    public void addEmployee(String firstName, String lastName) {

        clickPIM();

        clickAdd();

        enterFirstName(firstName);

        enterLastName(lastName);

        clickSave();

        wait.waitForLoaderToDisappear();
    }

}