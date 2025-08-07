package org.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        driver.manage().window().maximize();
        System.out.println("Current url: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().to("https://www.youtube.com");

        driver.manage().window().maximize();
        System.out.println("After Navigation....");
        System.out.println("Current url: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().back();

        System.out.println("Back Navigation....");
        System.out.println("Current url: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.navigate().forward();
        System.out.println("Forward Navigation....");
        System.out.println("Current url: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
