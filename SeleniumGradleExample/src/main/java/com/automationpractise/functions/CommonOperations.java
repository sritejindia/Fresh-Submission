package com.automationpractise.functions;

import com.automationpractise.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonOperations {

    private WebDriver webDriver;

    public CommonOperations(WebDriver driver) {
        webDriver = driver;
    }

    protected void launchWebSiteByUrl(String url) {
        webDriver.get(url);
    }

    protected void clickElement(By by) {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(DriverFactory.getCurrentDriver(), 20);
        //System.out.println(DriverFactory.getCurrentDriver().getPageSource());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void populateElement(By by, CharSequence charSequence) {
        DriverFactory.getCurrentDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        DriverFactory.getCurrentDriver().findElement(by).sendKeys(charSequence);
    }

    protected void maximizeBrowser() {
        webDriver.manage().window().maximize();
    }

    protected void waitForPageLoad() {
        new WebDriverWait(DriverFactory.getCurrentDriver(), 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    protected void waitForPageTitleLoad(String title) {
        new WebDriverWait(DriverFactory.getCurrentDriver(), 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.title").equals(title));
    }

    protected void selectDropdownValueByVisibleText(By by, String value) {
        Select selectDropdown = new Select(DriverFactory.getCurrentDriver().findElement(by));
        selectDropdown.selectByVisibleText(value);
    }
}
