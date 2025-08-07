package org.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Frame {
    static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(Frame.class);

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        driver.manage().window().maximize();

        //driver.switchTo().frame(0);
        driver.switchTo().frame("iframeResult");
        WebElement btn = driver.findElement(By.xpath("//button[text()='Try it']"));
        btn.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        log.info("Alert Text: {} ", alertText);

        String nameUser = "Bala";
        alert.sendKeys(nameUser);
        alert.accept();

        WebElement results = driver.findElement(By.xpath("//*[@id='demo']"));
        log.info("Results: {}", results.getText());
        driver.switchTo().parentFrame();
        log.info("Back to Parent Frame....");
        driver.quit();
    }
}
