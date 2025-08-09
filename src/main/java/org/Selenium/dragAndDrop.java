package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class dragAndDrop {
    private static final Logger log = LoggerFactory.getLogger(dragAndDrop.class);
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));

        WebElement source = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
        WebElement target = driver.findElement(By.xpath("//*[@id='trash']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
        sleep(3);
        log.info("Photo Manager done");

        driver.switchTo().defaultContent();
        WebElement acceptedElements = driver.findElement(By.xpath("//*[text()='Accepted Elements']"));
        acceptedElements.click();
        sleep(2);

        driver.switchTo().frame(driver.findElement(By.xpath("(//*[text()='Accepted Elements']//following::iframe[@class='demo-frame'])[2]")));

        WebElement source1 = driver.findElement(By.xpath("//*[@id='draggable-nonvalid']"));
        WebElement target1 = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        action.dragAndDrop(source1, target1).build().perform();
        sleep(3);
        log.info("Accepted Elements done");

        driver.switchTo().defaultContent();
        WebElement propagationElements = driver.findElement(By.xpath("//*[text()='Propagation']"));
        propagationElements.click();
        sleep(2);

        driver.switchTo().frame(driver.findElement(By.xpath("(//*[text()='Propagation']//following::iframe[@class='demo-frame'])[3]")));

        WebElement source2 = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target2 = driver.findElement(By.xpath("//*[@id='droppable2']"));
        action.dragAndDrop(source2, target2).build().perform();
        sleep(3);
        log.info("Propagation done");
        driver.quit();
    }

    public static void sleep(long seconds) {
        Actions action = new Actions(driver);
        action.pause(1000 * seconds).build().perform();
    }
}
