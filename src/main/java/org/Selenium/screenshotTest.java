package org.Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class screenshotTest {
    private static final Logger log = LoggerFactory.getLogger(screenshotTest.class);
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("src/test/resources/Screenshots/" + "google" + ".png");
            FileUtils.copyFile(srcFile, destFile);
            log.info("Screenshot Saved...");
        } catch (Exception e) {
            log.error("Error taking screenshot", e);
        }
        driver.quit();
    }
}
