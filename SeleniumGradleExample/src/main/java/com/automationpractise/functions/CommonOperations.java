package com.automationpractise.functions;

import org.openqa.selenium.WebDriver;

public class CommonOperations {

    private WebDriver webDriver;

    public CommonOperations(WebDriver driver) {
        webDriver = driver;
    }

    protected void launchWebSiteByUrl(String url) {
        webDriver.get(url);
    }
}
