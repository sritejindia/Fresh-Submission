package com.automationpractise.tests;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyLogin {
    @BeforeTest
    public void beforeTest() {
        new HomePage(DriverFactory.getCurrentDriver()).launchHomePage("http://automationpractice.com/index.php");
    }
    @Test
    public void test() {
        new HomePage(DriverFactory.getCurrentDriver())
                .clickSignInHyperlink()
                .enterEmailAddressAndPassword("pacific2@tet67.com", "ocean")
                .clickOnLoginBtn();
    }

    @AfterTest
    public void afterTest() {
        DriverFactory.closeCurrentBrowser();
    }
}
