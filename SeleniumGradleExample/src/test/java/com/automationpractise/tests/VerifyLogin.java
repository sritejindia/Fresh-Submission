package com.automationpractise.tests;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.pages.HomePage;
import org.testng.annotations.*;


public class VerifyLogin {

    @BeforeClass
    public static void beforeClass() {

    }

    @AfterClass
    public static void afterClass() {
    }

    @BeforeTest
    public void beforeTest() {
        new HomePage(DriverFactory.getCurrentDriver()).launchHomePage("http://automationpractice.com/index.php");
    }

    @Test
    public void test() {
        new HomePage(DriverFactory.getCurrentDriver())
                .clickSignInHyperlink()
                .enterCreateAccountEmailAddress("sritejindia@gmail.com")
                .clickCreateAccountButton();
    }

    @AfterTest
    public void afterTest() {
        DriverFactory.closeCurrentBrowser();
    }
}
