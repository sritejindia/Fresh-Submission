package com.automationpractise.pages;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.functions.CommonOperations;
import com.automationpractise.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AuthenticationPage extends CommonOperations {

    private WebDriver webDriver;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitForPageTitleLoad(Locator.loginPage_title);
        waitForPageLoad();
    }

    public AuthenticationPage enterCreateAccountEmailAddress(String email) {
        populateElement(By.id(Locator.email_creat_id), email);
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        clickElement(By.id(Locator.createAccountBtn_id));
        return new CreateAccountPage(DriverFactory.getCurrentDriver());
    }
}
