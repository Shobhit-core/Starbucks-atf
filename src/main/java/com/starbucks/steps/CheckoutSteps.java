package com.starbucks.steps;

import com.starbucks.utils.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.starbucks.pages.LoginPage;
import com.starbucks.pages.DrinkSelectionPage;
import com.starbucks.pages.CheckoutPage;
import com.starbucks.pages.CartPage;

public class CheckoutSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DrinkSelectionPage drinkSelectionPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.clickLoginButton();
    }

    @Given("User adds a drink to the cart")
    public void userAddsDrinkToCart() {
        drinkSelectionPage = new DrinkSelectionPage(driver);
        drinkSelectionPage.selectDrink("Latte");  // Example drink name
        drinkSelectionPage.addToCart();
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
    }

    @Then("User should see the checkout page")
    public void userShouldSeeCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        boolean isCheckoutPageDisplayed = checkoutPage.isCheckoutPageDisplayed();
        assert isCheckoutPageDisplayed : "Checkout page is not displayed";
    }

    @Then("User should be able to enter payment details and complete the purchase")
    public void userShouldCompletePurchase() {
        checkoutPage.enterPaymentDetails("CardDetails");
        checkoutPage.clickCompletePurchaseButton();
        boolean isPurchaseSuccessful = checkoutPage.isPurchaseSuccessful();
        assert isPurchaseSuccessful : "Checkout was not successful";
    }
}
