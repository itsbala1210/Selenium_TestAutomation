package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Set;

public class WindowHandlesTest {
    private static final Logger log = LoggerFactory.getLogger(WindowHandlesTest.class);
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHereButton = driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickHereButton.click();

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                log.info("Current Url: {}", driver.getCurrentUrl());
            }
        }

        WebElement results = driver.findElement(By.xpath("//h3[text()='New Window']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(results));
        String resultText = results.getText();
        log.info("Results: {}", resultText);
        log.info("Current Url: {}", driver.getCurrentUrl());

        driver.switchTo().window(parentWindow);
        log.info("Parent Window url: {}", driver.getCurrentUrl());
        driver.quit();
    }
}
