package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class synchronization {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement stringTxt = driver.findElement(By.name("q"));
        stringTxt.sendKeys("Selenium Introduction...");

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='btnK']")));

        WebElement searchBtn = driver.findElement(By.xpath("//*[@name='btnK']"));
        searchBtn.click();

        //Fluent wait
       /* FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(5)).
                pollingEvery(Duration.ofSeconds(2)).
                ignoring(NoSuchElementException.class);

        fluentWait.until(driver -> driver.findElement(By.xpath("//*[@name='btnK']")));
        */
        //Thread.sleep(2000);
        driver.quit();
    }
}
