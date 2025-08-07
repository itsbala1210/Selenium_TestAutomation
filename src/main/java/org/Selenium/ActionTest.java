package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionTest {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(ActionTest.class);

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
        sleep(3);
        String targetText = target.getText();
        log.info("Target text: {} ", targetText);
        log.info("Mouse Actions...");

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        WebElement searchBar = driver.findElement(By.name("q"));
        action.click(searchBar).keyUp(Keys.CONTROL).sendKeys(" Selenium Introduction...")
                .sendKeys(Keys.ENTER).build().perform();
        log.info("KeyBoard Actions...");
        driver.quit();
    }

    public static void sleep(long seconds) {
        Actions actions = new Actions(driver);
        actions.pause(seconds * 1000).build().perform();
    }
}
