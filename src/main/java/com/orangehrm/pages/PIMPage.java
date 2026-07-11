package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    
    By btnDelete = By.xpath("//i[@class='oxd-icon bi-trash']/parent::button");

    By btnYesDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
    
    By noRecordMessage = By.xpath("//span[normalize-space()='No Records Found']");
    
 // Edit Button
    By btnEdit = By.xpath("//i[contains(@class,'bi-pencil-fill')]/parent::button");

    By successToast = By.xpath("//p[text()='Successfully Updated']");
    
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

        wait.waitForElement(txtEmployeeName).click();

        wait.waitForElement(txtEmployeeName).sendKeys(Keys.CONTROL + "a");
        wait.waitForElement(txtEmployeeName).sendKeys(Keys.DELETE);

        wait.waitForElement(txtEmployeeName).sendKeys(employeeName);

        Thread.sleep(2000);

//        try {
//            wait.waitForClickable(suggestion).click();
//        } catch (Exception e) {
//            System.out.println("Suggestion not found");
//        }

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
    
    public void clickDelete() {

        wait.waitForClickable(btnDelete).click();

    }

    public void confirmDelete() {

        wait.waitForClickable(btnYesDelete).click();

    }
    public boolean isNoRecordDisplayed() {

        return wait.waitForElement(noRecordMessage).isDisplayed();

    }
    public void deleteEmployee(String employeeName) throws InterruptedException {
    	clickPIM();
    	
        clickEmployeeList();

        searchEmployee(employeeName);

        clickDelete();

        confirmDelete();

    }
    
    public void clickEdit() {

        wait.waitForClickable(btnEdit).click();

    }
    public void updateLastName(String lastName) {

        wait.waitForElement(txtLastName).clear();

        wait.waitForElement(txtLastName).sendKeys(lastName);

    }
    public boolean isUpdateSuccessful() {

        return wait.waitForElement(successToast).isDisplayed();

    }
    public void updateEmployee(String employeeName, String newLastName) throws InterruptedException {

        clickPIM();

        clickEmployeeList();

        searchEmployee(employeeName);

        clickEdit();

        updateLastName(newLastName);

        clickSave();

    }

}