package org.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.Duration;

public class HandlingPopupAndAlerts {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(HandlingPopupAndAlerts.class);

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //Alert -> Simple dialog with message and "OK" button
        WebElement alertBtn = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        alertBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        log.info("Alert Text: {}", alertText);
        alert.accept();
        log.info("Alert Accepted....");


        //Confirmation -> dialog with message and "Ok or Cancel" button
        WebElement confirmBtn = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        confirmBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String confirmText = alert.getText();
        log.info("Alert Text: {}", confirmText);
        alert.dismiss();
        log.info("Confirm Dismiss....");

        WebElement results = driver.findElement(By.id("result"));
        String resultText = results.getText();
        log.info("Result: {}", resultText);

        // Prompt -> dialog with message and "Entering text, Ok or Cancel" button

        WebElement promptBtn = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        promptBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String promptText = alert.getText();
        log.info("Alert Text: {}", promptText);

        String textUser = "Bala";
        alert.sendKeys(textUser);

        alert.accept();

        WebElement resultPrompt = driver.findElement(By.id("result"));
        String promptResults = resultPrompt.getText();
        log.info("Prompt Results: {}", promptResults);

        driver.quit();

    }
}
