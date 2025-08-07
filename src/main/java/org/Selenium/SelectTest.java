package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SelectTest {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(SelectTest.class);

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebElement dropElement = driver.findElement(By.xpath("//*[@id='dropdown']"));
        dropElement.click();

        Select select = new Select(dropElement);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            log.info("Options: {}", option.getText());
        }

        select.selectByVisibleText("Option 2");
        String selectedOption = select.getFirstSelectedOption().getText();
        log.info("Selected Option: {}", selectedOption);

        dropElement.click();
        select.selectByIndex(1);
        String selectedIndexOption = select.getFirstSelectedOption().getText();
        log.info("Selected Option: {}", selectedIndexOption);

        driver.quit();
    }
}
