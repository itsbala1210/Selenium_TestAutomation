package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Encapsulation {
    private WebDriver driver;
    private By searchBar = By.name("q");
    private By searchBtn = By.xpath("//*[@name='btnK']");

    public Encapsulation(WebDriver driver) {
        this.driver = driver;
    }

    public void searchText(String query) {
        WebElement searchTxt = driver.findElement(searchBar);
        searchTxt.sendKeys(query);
    }

    public void searchButton() {
        WebElement submitBtn = driver.findElement(searchBtn);
        submitBtn.click();
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Encapsulation gp = new Encapsulation(driver);

        gp.searchText("Selenium Introduction...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        gp.searchButton();

        driver.quit();
    }
}
