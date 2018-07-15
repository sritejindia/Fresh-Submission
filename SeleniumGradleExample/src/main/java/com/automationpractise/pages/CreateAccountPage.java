package com.automationpractise.pages;

import com.automationpractise.functions.CommonOperations;
import com.automationpractise.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends CommonOperations {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage selectTitle() {
        clickElement(By.id(Locator.title_radio_mr_css));
        return this;
    }
}
