package com.katalon.demoaut.tests;

import com.katalon.demoaut.functions.CommonFunctions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    public WebDriver driver = null;
    private final String screenshotsPath = "my-reports";

    @Before
    public void beforeMethod() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkLoginSuccessfully() {

        driver.get("http://demoaut.katalon.com");
        driver.findElement(By.id("btn-make-appointment")).click();
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("login")));


        //System.out.println("The username is: " + driver.findElement(By.cssSelector("div.alert-info input[placeholder='Username']")).getAttribute("value"));
        //System.out.println("The password is: " + driver.findElement(By.cssSelector("div.alert-info input[placeholder='Password']")).getAttribute("value"));
        //System.out.println("The page source is: " + driver.getPageSource());

        driver.findElement(By.id("txt-username")).sendKeys(driver.findElement(By.cssSelector("div.alert-info input[placeholder='Username']")).getAttribute("value"));
        driver.findElement(By.id("txt-password")).sendKeys(driver.findElement(By.cssSelector("div.alert-info input[placeholder='Password']")).getAttribute("value"));
        driver.findElement(By.id("btn-login")).click();

        webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("appointment")));

        Select facilityDropdown = new Select(driver.findElement(By.id("combo_facility")));
        facilityDropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.cssSelector("input[type='radio'][name='programs'][value='Medicaid']"));
        driver.findElement(By.id("txt_visit_date")).sendKeys("12/09/2018");
        driver.findElement(By.id("txt_comment")).sendKeys("Thus made an appointment");
        driver.findElement(By.id("btn-book-appointment")).click();

        webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("summary")));

        System.out.println("The facility chosen is: " + driver.findElement(By.id("facility")).getText());
        System.out.println("The hospital readmission is: " + driver.findElement(By.id("hospital_readmission")).getText());
        System.out.println("The program chosen is: " + driver.findElement(By.id("program")).getText());
        System.out.println("Your comments are: " + driver.findElement(By.id("comment")).getText());
        CommonFunctions.takeScreenshot(driver,screenshotsPath);
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
