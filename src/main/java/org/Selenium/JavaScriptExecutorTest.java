package org.Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptExecutorTest {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(JavaScriptExecutorTest.class);

    public static void main(String[] args) {
        driver = new ChromeDriver();
        //executeScript below
        /*
        driver.get("https://www.w3schools.com/");
        driver.manage().window().maximize();

        WebElement jsElement = driver.findElement(By.xpath("//*[text()='Learn W3.CSS']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", jsElement);

        String pageTitle = (String) jsExecutor.executeScript("return document.title");
        log.info("Page Title: {}", pageTitle);
        sleep(3);
        jsExecutor.executeScript("arguments[0].click();", jsElement);

        log.info("Elements Scrolled and Clicked...");

        driver.quit();
        */

        //executeAsyncScript below
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "var callback = arguments[arguments.length-1];" + "setTimeout(function(){callback('Delayed 2 seconds...');},2000);";
        String results = (String) jsExecutor.executeAsyncScript(script);
        log.info("Results: {}", results);
        driver.quit();

    }

    public static void sleep(long seconds) {
        Actions actions = new Actions(driver);
        actions.pause(seconds * 1000).build().perform();
    }
}
