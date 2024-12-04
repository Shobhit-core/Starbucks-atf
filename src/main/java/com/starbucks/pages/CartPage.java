package com.starbucks.pages;

import com.starbucks.Elements.Elements;
import com.starbucks.utils.defaultmethods;
import org.openqa.selenium.WebDriver;

public class CartPage extends Base {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUserIcon() {
        defaultmethods.sleep(10000);
        defaultmethods.switchToIframe(Elements.userIframe);
        clickElement(Elements.userIcon);
    }

    public void clickOnSignUpButton() {
        defaultmethods.waitForElementToBeVisible(Elements.signUpButton, 10);
        clickElement(Elements.signUpButton);
    }

    public void enterUsername(String username) {
        defaultmethods.waitForElementToBeVisible(Elements.usernameField, 10);
        defaultmethods.clearAndSendText(Elements.usernameField, username);
    }

    public void enterPassword(String password) {
        defaultmethods.waitForElementToBeVisible(Elements.passwordField, 10);
        defaultmethods.clearAndSendText(Elements.passwordField, password);
    }

    public void clickLoginButton() {
        defaultmethods.waitForElementToBeClickable(Elements.loginButton, 10);
        clickElement(Elements.loginButton);
    }

    public void clickLogoutButton() {
        defaultmethods.waitForElementToBeClickable(Elements.logoutButton, 10);
        clickElement(Elements.logoutButton);
    }

    public void login(String validUser, String validPassword) {

       clickOnUserIcon();
        enterUsername(validUser);
        enterPassword(validPassword);
        clickLoginButton();
    }

    public void clickCheckoutButton() {
    }
}
