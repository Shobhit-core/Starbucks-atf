package com.starbucks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

    public WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sendText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}
