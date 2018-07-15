package com.automationpractise.pages;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.functions.CommonOperations;
import com.automationpractise.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonOperations {
    private WebDriver webDriver;

    public HomePage(WebDriver driver) {
        super(driver);
        webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void launchHomePage(String url) {
        launchWebSiteByUrl(url);
        maximizeBrowser();
        waitForPageLoad();
    }


    public AuthenticationPage clickSignInHyperlink() {
        clickElement(By.cssSelector(Locator.signInLink_css));
        return new AuthenticationPage(DriverFactory.getCurrentDriver());
    }
}
