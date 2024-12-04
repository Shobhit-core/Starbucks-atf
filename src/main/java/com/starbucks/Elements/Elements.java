package com.starbucks.Elements;

import org.openqa.selenium.By;

public class Elements {

    // LoginPage Locators
    public  static final By signUpButton = By.xpath("//button[contains(text(),\"Login\")]");
    public  static final By userIframe = By.xpath("//iframe[@title='gtm']");
    public static final By userIcon = By.id("dropdownUser1");
    public static final By usernameField = By.xpath("//input[@formcontrolname=\"emailOrMobile\"]");
    public static final By passwordField = By.xpath("//input[@formcontrolname=\"password\"]");
    public static final By loginButton = By.xpath("//button[@type=\"submit\"]");
    public static final By errorMsg = By.xpath("//*[contains(text(),'Retry with correct details')]");
    public static final By welcomeDownArrow = By.xpath("//span[@class=\"arrow\"]");
    public static final By logoutButton = By.xpath("//*[contains(text(),\"LOG OUT\")]");
    public static final By logout = By.xpath("//button[contains(text(),\"Log out\")]");


    // DrinkSelectionPage Locators
    public static final By drinkSelector = By.id("drink-selector");
    public static final By addToCartButton = By.id("add-to-cart");
    public static final By cartIcon = By.id("cart-icon");

    // CheckoutPage Locators
    public static final By checkoutButton = By.id("checkout");
    public static final By placeOrderButton = By.id("place-order");
    public static final By paymentMethodDropdown = By.id("payment-method");
    public static final By confirmOrderButton = By.id("confirm-order");

}
