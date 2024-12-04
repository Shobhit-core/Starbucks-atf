Feature: Checkout functionality with Login and Drink Selection

  @Checkout
  Scenario: User logs in, adds drink to the cart, and proceeds to checkout
    Given User navigates to the Starbucks home page
    And User logs in with valid credentials
    And User adds a drink to the cart
    When User proceeds to checkout
    Then User should see the checkout page
    And User should be able to enter payment details and complete the purchase
