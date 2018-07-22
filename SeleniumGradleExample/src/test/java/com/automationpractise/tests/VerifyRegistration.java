package com.automationpractise.tests;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.pages.HomePage;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class VerifyRegistration {

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
                .clickCreateAccountButton()
                .selectTitle("Mr.")
                .enterName("sritej", "kurapati")
                .enterPassword("trisha!@#")
                .enterDOB(LocalDate.parse("19/07/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .enterAddress("1251 Main St", "Brockton", "Brockton", "Massachusetts", "02301", "United States")
                .enterMobileNumber("9935465768")
                .clickRegisterBtn();
    }

    @AfterTest
    public void afterTest() {
        DriverFactory.closeCurrentBrowser();
    }
}
