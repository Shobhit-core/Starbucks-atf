package com.starbucks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends Base {

    private By checkoutButton = By.id("checkout");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        clickElement(checkoutButton);
    }

    public boolean isCheckoutPageDisplayed() {
        return driver.findElement(checkoutButton).isDisplayed();
    }

    public void enterPaymentDetails(String cardDetails) {
    }

    public void clickCompletePurchaseButton() {
    }

    public boolean isPurchaseSuccessful() {
        return false;
    }
}
