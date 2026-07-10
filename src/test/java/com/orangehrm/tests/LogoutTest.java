package com.orangehrm.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        login.login("Admin", "admin123");

        dashboard.logout();

        assertTrue(driver.getCurrentUrl().contains("login"));

    }

}