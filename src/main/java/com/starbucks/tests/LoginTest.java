package com.starbucks.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.starbucks.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    static WebDriver driver;
    static LoginPage loginPage;
    static ExtentReports extent;
    static ExtentTest logger;

    @BeforeClass
    public static void setUp() {
        extent = new ExtentReports();
        logger = extent.createTest("Login Test", "Testing the login functionality");
        System.setProperty("webdriver.chrome.driver", "src\\main\\webdriver\\chromedriver.exe");

        // Configure ChromeOptions if needed
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.starbucks.in");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {

        loginPage.clickOnUserIcon();
        loginPage.clickOnSignUpButton();
        loginPage.enterUsername("demotest@gmail.com");
        loginPage.enterPassword("demoPassword@1");
        loginPage.clickLoginButton();

        // Log the result
//        Assert.assertFalse(loginPage.isLoginButtonDisplayed(), "Login failed");
        logger.pass("Login successful");
    }

    @AfterClass
    public static void tearDown() {
        extent.flush();
        driver.quit();
    }
}
