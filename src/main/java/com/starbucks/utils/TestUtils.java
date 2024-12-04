package com.starbucks.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.starbucks.steps.Hooks.driver;

public class TestUtils {

    // Wait for an element to be visible
    public static void waitForElementToBeVisible(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Wait for an element to be clickable
    public static void waitForElementToBeClickable(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for an element to be present in the DOM
    public static void waitForElementPresence(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Sleep for a specific amount of time (in milliseconds)
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to switch to an iframe using any locator (XPath, CSS selector, etc.)
    public static void switchToIframe(WebDriver driver, By iframeLocator) {
        try {
            WebElement iframe = driver.findElement(iframeLocator);
            driver.switchTo().frame(iframe); // Switch to iframe
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe: " + e.getMessage());
        }
    }

    // Method to switch to an iframe using its index (0-based index)
    public static void switchToIframeByIndex(WebDriver driver, int iframeIndex) {
        try {
            driver.switchTo().frame(iframeIndex); // Switch to iframe by index
        } catch (Exception e) {
            System.out.println("Failed to switch to iframe by index: " + e.getMessage());
        }
    }

    // Method to switch back to the default content (main page)
    public static void switchToDefaultContent(WebDriver driver) {
        try {
            driver.switchTo().defaultContent(); // Switch back to the main page
        } catch (Exception e) {
            System.out.println("Failed to switch back to default content: " + e.getMessage());
        }
    }
    // Get text of an element
    public static String getElementText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    // Clear text field and send new text
    public static void clearAndSendText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isElementExist(By locator, int timeoutInSeconds) {
        try {
            // Use WebDriverWait to wait for the element to become visible or exist
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed(); // Check if the element is visible
        } catch (Exception e) {
            // If the element is not found within the timeout, return false
            return false;
        }
    }
}
