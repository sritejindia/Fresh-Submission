package com.automationpractise.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {
    private static WebDriver mDriver;

    public synchronized static WebDriver getCurrentDriver() {
        if(mDriver == null) {
         mDriver = new SafariDriver(new SafariOptions());
        }
        return mDriver;
    }
}
