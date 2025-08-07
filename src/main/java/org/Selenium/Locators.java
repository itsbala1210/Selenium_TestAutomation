package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.id("search"));
        driver.findElement(By.name("q"));
        driver.findElement(By.className("gLFyf"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.cssSelector("input[name='q']"));
        driver.findElement(By.xpath("//*[@name='q']"));

        //sample
        driver.findElement(By.linkText("More information..."));
        driver.findElement((By.partialLinkText("More")));
        driver.findElement(By.cssSelector("input.gLFyf"));
    }
}
