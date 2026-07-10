package com.orangehrm.tests;

import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.ExcelUtility;

public class LoginTest extends BaseTest {
	@DataProvider(name = "loginData")

	public Object[][] getLoginData() throws Exception {

		return ExcelUtility.getTestData("LoginData");

	}

	@Test
	public void verifyValidLogin() {

		LoginPage loginPage = new LoginPage(driver);

		ConfigReader config = new ConfigReader();

		loginPage.login(

				config.getProperty("username"),

				config.getProperty("password")

		);

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

	@Test(dataProvider = "loginData")

	public void verifyLogin(String username, String password, String expected) {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);

		loginPage.login(username, password);
		
		if (expected.equalsIgnoreCase("Pass")) {

			Assert.assertTrue(dashboardPage.isDashboardDisplayed());

			dashboardPage.logout();

		}

		else {

			Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");

		}
	}

}