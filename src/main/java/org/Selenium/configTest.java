package org.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class configTest {
    private static final configTest configProperty = new configTest();
    private static final String file = "src/test/resources/config.properties";
    private static final Logger log = LoggerFactory.getLogger(configTest.class);
    private Properties properties;
    static WebDriver driver;

    private configTest() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (Exception e) {
            log.info("File is not load...");
        }
    }

    public static configTest getInstance() {
        return configProperty;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        configTest cp = new configTest();
        configTest.getInstance();
        String browser = cp.getProperty("Browser");
        log.info("Browser Name: {}", browser);
        String url = cp.getProperty("Base_Url");
        log.info("Base Url: {}", url);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.quit();
    }
}
