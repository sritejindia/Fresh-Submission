package com.automationpractise.pages;

import com.automationpractise.functions.CommonOperations;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage extends CommonOperations {
    WebDriver webDriver;

    public LoggedInHomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        waitForPageLoad();
    }
}
