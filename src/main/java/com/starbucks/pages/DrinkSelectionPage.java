package com.starbucks.pages;

import com.starbucks.Elements.Elements;
import org.openqa.selenium.WebDriver;
import com.starbucks.utils.defaultmethods;

public class DrinkSelectionPage extends Base {

    public DrinkSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void selectDrink(String drinkName) {
        defaultmethods.waitForElementToBeVisible(Elements.drinkSelector, 10);
        defaultmethods.clearAndSendText(Elements.drinkSelector, drinkName);
    }

    public void addToCart() {
        defaultmethods.waitForElementToBeClickable(Elements.addToCartButton, 10);
        clickElement(Elements.addToCartButton);
    }

    public void viewCart() {
        defaultmethods.waitForElementToBeClickable(Elements.cartIcon, 10);
        clickElement(Elements.cartIcon);
    }
}
