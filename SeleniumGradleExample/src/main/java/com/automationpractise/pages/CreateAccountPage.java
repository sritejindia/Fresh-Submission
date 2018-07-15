package com.automationpractise.pages;

import com.automationpractise.functions.CommonOperations;
import com.automationpractise.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class CreateAccountPage extends CommonOperations {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
    }

    public CreateAccountPage selectTitle(String title) {
        clickElement(title.equals("Mr.") ? By.cssSelector(Locator.title_radio_mr_css) : By.cssSelector(Locator.title_radio_mrs_css));
        return this;
    }

    public CreateAccountPage enterName(String firstName, String lastName) {
        populateElement(By.id(Locator.customer_firstname_id), firstName);
        populateElement(By.id(Locator.customer_lastname_id), lastName);
        return this;
    }

    public CreateAccountPage enterPassword(String password) {
        populateElement(By.id(Locator.password_id), password);
        return this;
    }

    public CreateAccountPage enterDOB(LocalDate parse) {
        // selectDropdownValueByVisibleText(By.id(Locator.dob_days_dropdown_id),Integer.toString(parse.getDayOfMonth()));
        selectDropdownValueByVisibleText(By.id(Locator.dob_months_dropdown_id), parse.getMonth().name());
        selectDropdownValueByVisibleText(By.id(Locator.dob_years_dropdown_id), Integer.toString(parse.getYear()));
        return this;
    }
}
