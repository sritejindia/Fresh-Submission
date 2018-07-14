package com.automationpractise.pages;

import com.automationpractise.functions.CommonOperations;
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
    }
}
