package com.starbucks.steps;

import com.starbucks.Elements.Elements;
import com.starbucks.pages.LoginPage;
import com.starbucks.utils.ExcelUtil;
import com.starbucks.utils.defaultmethods;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class LoginSteps {

    private final WebDriver driver;
    private final LoginPage loginPage;
    private final ExcelUtil excelUtil;

    public LoginSteps() throws IOException {
        this.driver = Hooks.getDriver(); // Access the shared WebDriver from Hooks
        this.loginPage = new LoginPage(driver); // Initialize LoginPage with the shared driver
        this.excelUtil = new ExcelUtil("src/test/resources/Test_Data.xlsx", "Test_Data"); // Initialize ExcelUtil
    }

    @Given("User navigates to the Starbucks login page")
    public void userNavigatesToTheStarbucksLoginPage(){
        loginPage.clickOnUserIcon();
        loginPage.clickOnSignUpButton();
    }


    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        String username = excelUtil.getCellData(1, 2);
        String password = excelUtil.getCellData(1, 3);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        loginPage.clickLogoutIfRequired();
    }

    @Then("User should be redirected to the home page")
    public void userShouldBeRedirectedToTheHomePage() {
        Assert.assertTrue(driver.getTitle().contains("Starbucks"));
    }

    @When("User enters invalid username and password")
    public void invalidUsernameAndPassword() {
        String username = excelUtil.getCellData(2, 2);
        String password = excelUtil.getCellData(2, 3);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the dashboard")
    public void userShouldBeLoggedInAndRedirectedToTheDashboard() {
        if (defaultmethods.isElementExist(Elements.welcomeDownArrow,20)){
            defaultmethods.click(Elements.welcomeDownArrow);
        }
        defaultmethods.sleep(5);
        Assert.assertTrue("Dashboard page verification failed.", driver.getCurrentUrl().contains("dashboard"));

    }

    @Then("User should see an error message indicating invalid credentials")
    public void userShouldSeeAnErrorMessageIndicatingInvalidCredentials() {
        Assert.assertTrue("Invalid credentials error message not displayed.", loginPage.isInvalidCredentialsErrorDisplayed());


    }

    @Then("User should see an error message indicating that fields cannot be empty")
    public void userShouldSeeAnErrorMessageIndicatingThatFieldsCannotBeEmpty() {
//        Assert.assertTrue("Empty fields error message not displayed.", loginPage.isEmptyFieldsErrorDisplayed());

    }

    @Then("User verify the dashboard stars and rewards")
    public void userVerifyTheDashboardStarsAndRewards() {
                Assert.assertTrue("Empty fields error message not displayed.", loginPage.isInvalidCredentialsErrorDisplayed());


    }

    @Then("User logout from the website")
    public void userLogoutFromTheWebsite() {
        loginPage.clickOnUserIcon();
        loginPage.clickLogoutButton();

    }
}
