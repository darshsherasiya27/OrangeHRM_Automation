package com.orangehrm.tests;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;

public class PIMTest extends BaseTest {

	@Test
	public void verifyAddEmployee() throws InterruptedException {

	    LoginPage loginPage = new LoginPage(driver);
	    PIMPage pimPage = new PIMPage(driver);

	    String firstName = "Darsh" + System.currentTimeMillis();
	    String lastName = "QA";

	    loginPage.login("Admin", "admin123");

	    pimPage.addEmployee(firstName, lastName);
	    
	    System.out.println("Current URL : " + driver.getCurrentUrl());

	    Thread.sleep(3000);

	    System.out.println("URL After 3 sec : " + driver.getCurrentUrl());

	    assertTrue(pimPage.isPersonalDetailsPageDisplayed());	
	    }
	@Test
	public void verifyDeleteEmployee() throws InterruptedException {

	    LoginPage loginPage = new LoginPage(driver);
	    PIMPage pimPage = new PIMPage(driver);
	    String firstName = "Darsh" + System.currentTimeMillis();
	    String lastName = "QA";

	    loginPage.login("Admin", "admin123");

	    pimPage.addEmployee(firstName, lastName);
	    Thread.sleep(3000);
	    pimPage.clickEmployeeList();
	    pimPage.searchEmployee(firstName);

	    pimPage.deleteEmployee(firstName);

	    assertTrue(pimPage.isNoRecordDisplayed());

	}
	
	@Test
	public void verifyUpdateEmployee() throws InterruptedException {

	    LoginPage loginPage = new LoginPage(driver);
	    PIMPage pimPage = new PIMPage(driver);
	    String firstName = "Darsh" + System.currentTimeMillis();
	    String lastName = "QA";

	    loginPage.login("Admin", "admin123");

	    pimPage.addEmployee(firstName, lastName);
	    Thread.sleep(3000);
	    pimPage.clickEmployeeList();
	    pimPage.searchEmployee(firstName);

	    pimPage.clickEdit();

	    pimPage.updateLastName("Automation");

	    pimPage.clickSave();

	    assertTrue(pimPage.isUpdateSuccessful());
	}
}