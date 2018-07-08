package com.automationpractise.tests;

import com.automationpractise.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        new HomePage(driver).launcHomePage().clickOnSignInBtn().enterCreateAccountEmailAddress("sritej@test2.com").clickCreateAcctBtn();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
