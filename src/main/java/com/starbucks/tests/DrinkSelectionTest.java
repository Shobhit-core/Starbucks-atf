//package com.starbucks.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//import stepDefinations.LoginSteps;
//import com.starbucks.pages.DrinkSelectionPage;
//
//public class DrinkSelectionTest extends LoginSteps {
//
//    @Test
//    public void testDrinkSelection() {
//        DrinkSelectionPage drinkSelectionPage = new DrinkSelectionPage(driver);
//        drinkSelectionPage.selectDrink("Latte");
//        drinkSelectionPage.addToCart();
//
//        // Example assertion after adding to cart
//        Assert.assertTrue(driver.getPageSource().contains("Drink added to cart"));
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
//}
