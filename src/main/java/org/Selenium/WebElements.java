package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebElements {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(WebElements.class);

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Selenium Introduction");
        Thread.sleep(2000);
        searchBar.clear();
        searchBar.sendKeys("DSA Introduction...");
        Dimension sizes = searchBar.getSize();
        log.info("Width: {}", sizes.getWidth());
        log.info("Height: {}", sizes.getHeight());

        WebElement searchBtn = driver.findElement(By.xpath("//*[@name='btnK']"));
        searchBtn.click();
        driver.quit();
    }
}
