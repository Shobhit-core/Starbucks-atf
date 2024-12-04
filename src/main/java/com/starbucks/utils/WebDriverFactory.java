package com.starbucks.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.service.DriverService;
import java.io.File;
import java.io.IOException;

public class WebDriverFactory {

    private WebDriver driver;

    // Initialize WebDriver based on the browser type
    public WebDriver initDriver(String browser) {
        String driverPath = "src/main/webdriver";  // Path to the driver executable (e.g., chromedriver.exe)

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");  // Set path to ChromeDriver
                ChromeOptions options = new ChromeOptions();
                // Initialize ChromeDriver with a Service object (Selenium 4)
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(driverPath + "/chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();

                driver = new ChromeDriver(service, options); // Initialize the ChromeDriver
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");  // Set path to GeckoDriver
                driver = new FirefoxDriver(); // Initialize the FirefoxDriver
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", driverPath + "/msedgedriver.exe");  // Set path to EdgeDriver
                driver = new EdgeDriver(); // Initialize the EdgeDriver
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();  // Maximize the browser window
        return driver;
    }

    // Cleanup after each test
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the WebDriver session
        }
    }
}
