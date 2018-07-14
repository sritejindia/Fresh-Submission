package com.automationpractise.tests;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;


public class VerifyLogin {

    @BeforeTest
    public void beforeMethod() {
        new HomePage(DriverFactory.getCurrentDriver()).launchHomePage("http://automationpractice.com/index.php");
    }

    @Test
    public void test() {

    }

    @AfterTest
    public void afterMethod() {
        DriverFactory.getCurrentDriver().close();
        DriverFactory.getCurrentDriver().quit();
    }
}
