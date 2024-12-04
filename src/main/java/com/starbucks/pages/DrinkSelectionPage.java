package com.starbucks.pages;

import com.starbucks.Elements.Elements;
import org.openqa.selenium.WebDriver;
import com.starbucks.utils.TestUtils;

public class DrinkSelectionPage extends Base {

    public DrinkSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void selectDrink(String drinkName) {
        TestUtils.waitForElementToBeVisible(driver, Elements.drinkSelector, 10);
        TestUtils.clearAndSendText(driver, Elements.drinkSelector, drinkName);
    }

    public void addToCart() {
        TestUtils.waitForElementToBeClickable(driver, Elements.addToCartButton, 10);
        clickElement(Elements.addToCartButton);
    }

    public void viewCart() {
        TestUtils.waitForElementToBeClickable(driver, Elements.cartIcon, 10);
        clickElement(Elements.cartIcon);
    }
}
