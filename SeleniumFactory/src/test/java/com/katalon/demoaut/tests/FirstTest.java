package com.katalon.demoaut.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    public WebDriver driver = null;

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

    }

    @After
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
