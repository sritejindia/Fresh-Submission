package com.automationpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public HomePage launcHomePage() {
        driver.get("http://automationpractice.com");
        return new HomePage(driver);
    }

    public LoginPage clickOnSignInBtn() {
    WebDriverWait driverWait =    new WebDriverWait(driver,20);
    driverWait.until(ExpectedConditions.elementToBeClickable(signInLink)).clear();


        return new LoginPage(driver);
    }
}
