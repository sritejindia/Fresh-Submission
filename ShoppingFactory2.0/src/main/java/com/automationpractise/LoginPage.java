package com.automationpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "email_create")
    private WebElement createAcctEmailAddr;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement createAcctBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public LoginPage enterCreateAccountEmailAddress(String val) {
        createAcctEmailAddr.sendKeys(val);
        return this;
    }

    public void clickCreateAcctBtn() {
        createAcctBtn.click();
    }
}
