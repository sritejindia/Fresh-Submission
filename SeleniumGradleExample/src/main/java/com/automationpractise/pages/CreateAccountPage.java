package com.automationpractise.pages;

import com.automationpractise.drivers.DriverFactory;
import com.automationpractise.functions.CommonOperations;
import com.automationpractise.locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
       /* clickElement(By.id(Locator.dob_days_tempdropdown_id));
        new Select(DriverFactory.getCurrentDriver().findElement(By.id("days"))).selectByVisibleText("regexp:6\\s+");
        DriverFactory.getCurrentDriver().findElement(By.xpath("//option[@value='6']")).click();
        new Select(DriverFactory.getCurrentDriver().findElement(By.id("months"))).selectByVisibleText("regexp:June\\s");
        DriverFactory.getCurrentDriver().findElement(By.xpath("(//option[@value='6'])[2]")).click();
        DriverFactory.getCurrentDriver().findElement(By.id("years")).click();
        new Select(DriverFactory.getCurrentDriver().findElement(By.id("years"))).selectByVisibleText("regexp:2012\\s+");
        DriverFactory.getCurrentDriver().findElement(By.xpath("//option[@value='2012']")).click();*/

        Actions builder = new Actions(DriverFactory.getCurrentDriver());
        builder.moveToElement(DriverFactory.getCurrentDriver().findElement(By.id(Locator.dob_days_tempdropdown_id))).click().build().perform();

        return this;
    }


    public CreateAccountPage enterAddressRecipientNameAndCompany(String firstName, String lastName, String company) {
        populateElement(By.id(Locator.address_firstname_id), firstName);
        populateElement(By.id(Locator.address_lastname_id), lastName);
        populateElement(By.id(Locator.address_company_id), company);
        return this;
    }

    public CreateAccountPage enterAddress(String addr1, String addr2, String city, String state, String zipcode, String country) {
        populateElement(By.id(Locator.address_addressLine1_id), addr1);
        populateElement(By.id(Locator.address_addressLine2_id), addr2);
        populateElement(By.id(Locator.address_city_id), city);
        selectDropdownValueByVisibleText(By.id(Locator.address_state_dropdown_id), state);
        clickElement(By.id("uniform-id_state"));
        clickElement(By.cssSelector("#id_state > option:nth-child(23)"));
        populateElement(By.id(Locator.address_zipcode_id), zipcode);
        //selectDropdownValueByVisibleText(By.id(Locator.address_country_dropdown_id), country);
        return this;
    }

    public CreateAccountPage enterMobileNumber(String mobileNumber) {
        populateElement(By.id(Locator.address_mobilephone_id), mobileNumber);
        return this;
    }

    public void clickRegisterBtn() {
        clickElement(By.id(Locator.my_register_btn_id));
    }
}
