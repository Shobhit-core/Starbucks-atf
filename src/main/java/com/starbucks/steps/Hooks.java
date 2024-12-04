package com.starbucks.steps;

import com.starbucks.utils.*;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Hooks {

    public static WebDriver driver; // Make the driver static to share it across classes
    private final WebDriverFactory webDriverFactory = new WebDriverFactory();

    @Before
    public void beforeEach(Scenario scenario) throws Exception {
        // Initialize ExcelUtil and fetch browser and URL data for each scenario
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Test_Data.xlsx", "Test_Data");

        String browser = excelUtil.getBrowserFromExcel(1);  // Get browser from Excel (row 0)
        driver = webDriverFactory.initDriver(browser);       // Initialize WebDriver
        String url = excelUtil.getCellData(1, 1);           // Get URL from Excel (row 0)
        driver.get(url);                                     // Navigate to the URL

        System.out.println("Running scenario: " + scenario.getName());
    }

    @After
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed() && isPageLoaded()) {
            takeScreenshot(scenario.getName());
        }
        webDriverFactory.tearDown();
    }

    private boolean isPageLoaded() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String readyState = jsExecutor.executeScript("return document.readyState;").toString();
        return readyState.equals("complete");
    }

    private void takeScreenshot(String scenarioName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("target/screenshots/" + scenarioName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Provide access to the WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
}
