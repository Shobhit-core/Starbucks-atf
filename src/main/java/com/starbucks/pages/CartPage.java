package com.starbucks.pages;

import com.starbucks.Elements.Elements;
import com.starbucks.utils.TestUtils;
import org.openqa.selenium.WebDriver;

public class CartPage extends Base {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUserIcon() {
        TestUtils.sleep(10000);
        TestUtils.switchToIframe(driver, Elements.userIframe);
        clickElement(Elements.userIcon);
    }

    public void clickOnSignUpButton() {
        TestUtils.waitForElementToBeVisible(driver, Elements.signUpButton, 10);
        clickElement(Elements.signUpButton);
    }

    public void enterUsername(String username) {
        TestUtils.waitForElementToBeVisible(driver, Elements.usernameField, 10);
        TestUtils.clearAndSendText(driver, Elements.usernameField, username);
    }

    public void enterPassword(String password) {
        TestUtils.waitForElementToBeVisible(driver, Elements.passwordField, 10);
        TestUtils.clearAndSendText(driver, Elements.passwordField, password);
    }

    public void clickLoginButton() {
        TestUtils.waitForElementToBeClickable(driver, Elements.loginButton, 10);
        clickElement(Elements.loginButton);
    }

    public void clickLogoutButton() {
        TestUtils.waitForElementToBeClickable(driver, Elements.logoutButton, 10);
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
