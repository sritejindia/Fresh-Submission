package com.katalon.demoaut.functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CommonFunctions {

    public static void takeScreenshot(WebDriver driver, String filePath) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(new StringBuilder(filePath).append("/").append(getCurrentDate()).append(getCurrentTime()).append(".jpg").toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    public static String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmSS"));

    }
}
