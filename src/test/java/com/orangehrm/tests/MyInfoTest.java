package com.orangehrm.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MyInfoPage;

public class MyInfoTest extends BaseTest {

    @Test
    public void verifyUpdatePersonalDetails() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        MyInfoPage myInfoPage = new MyInfoPage(driver);

        loginPage.login("Admin", "admin123");

        myInfoPage.clickMyInfo();

        String otherId = "QA" + System.currentTimeMillis();

        myInfoPage.updateOtherId(otherId);

        myInfoPage.clickSave();
        Thread.sleep(1000);
        assertTrue(myInfoPage.isUpdateSuccessful());
    }
}