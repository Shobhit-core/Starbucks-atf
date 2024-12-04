package com.starbucks.pages;

import com.starbucks.Elements.Elements;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.starbucks.utils.defaultmethods;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUserIcon() {
        defaultmethods.sleep(10000);
        defaultmethods.switchToIframe(Elements.userIframe);
        clickElement(Elements.userIcon);
    }

    public void clickOnLogoutButton() {
        defaultmethods.waitForElementToBeVisible(Elements.loginButton,30);
        clickElement(Elements.logoutButton);
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
        defaultmethods.waitForElementPresence(Elements.logoutButton, 10);
        WebElement logoutButton = driver.findElement(Elements.logoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);
        Assert.assertTrue("User is not logged out successfully",defaultmethods.isElementExist(Elements.usernameField,10));
    }

    public void login(String validUser, String validPassword) {

        clickOnUserIcon();
        clickOnSignUpButton();
        enterUsername(validUser);
        enterPassword(validPassword);
        clickLoginButton();
    }

    public boolean isInvalidCredentialsErrorDisplayed() {
        return defaultmethods.isElementExist(Elements.errorMsg,20);
    }

    public void clickLogoutIfRequired() {
        if (defaultmethods.isElementExist(Elements.logout, 5)) {
            defaultmethods.click(Elements.logout);
        }
    }
}
