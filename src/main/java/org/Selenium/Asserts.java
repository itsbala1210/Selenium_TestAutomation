package org.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Asserts {
    private static final Logger log = LoggerFactory.getLogger(Asserts.class);
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        log.info("Page: {}", pageTitle);
        //Hard Asserts

        Assert.assertEquals("Google", pageTitle, "Title doesn't match...");


        SoftAssert sa = new SoftAssert();
        sa.assertEquals("Google", pageTitle, "Title Doesn't match...");
        sa.assertAll();
        driver.quit();
    }
}
