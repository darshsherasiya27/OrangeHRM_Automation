package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void verifyValidLogin() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.login("Admin", "admin123");

	    DashboardPage dashboardPage = new DashboardPage(driver);

	    Assert.assertTrue(dashboardPage.isDashboardDisplayed());

	    dashboardPage.logout();

	    Assert.assertTrue(loginPage.isLoginPageDisplayed());

	    System.out.println("Login and Logout Successful");

	}
	@Test
	public void verifyInvalidLogin() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.login("Admin123", "admin123");

	    String actualMessage = loginPage.getErrorMessage();

	    Assert.assertEquals(actualMessage, "Invalid credentials");

	    System.out.println("Invalid Login Test Passed");

	}
    

}