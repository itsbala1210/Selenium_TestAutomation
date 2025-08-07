package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebElementsTest {
    private static final Logger log = LoggerFactory.getLogger(WebElementsTest.class);
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        List<WebElement> products = driver.findElements(By.xpath("//h4[contains(@class,'product-name')]"));
        for (WebElement product : products) {
            String productName = product.getText().split("-")[0].trim();
            log.info("Product Name: {}", productName);
        }

        for (WebElement product : products) {
            String productName = product.getText().split("-")[0].trim();
            log.info("First Product Name: {}", productName);
            break;
        }

        WebElement lastProduct = null;
        for (WebElement product : products) {
            lastProduct = product;
        }
        if (lastProduct != null) {
            String productName = lastProduct.getText().split("-")[0].trim();
            log.info("Last Product Name: {}", productName);
        }
        driver.quit();
    }
}
