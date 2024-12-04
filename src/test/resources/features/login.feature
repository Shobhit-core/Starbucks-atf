Feature: Login functionality of Starbucks website

  @login
  Scenario: Valid login with correct credentials
    Given User navigates to the Starbucks login page
    When User enters valid username and password
    And User should be redirected to the dashboard
    Then User logout from the website

  @guestUser
  Scenario: Verify the dashboard with guest user
    Given User should be redirected to the home page
    Then User should be redirected to the dashboard

  @invalidLogin
  Scenario: Invalid login with incorrect credentials
    Given User navigates to the Starbucks login page
    When User enters invalid username and password
    Then User should see an error message indicating invalid credentials

  @dashboardStars
  Scenario: Verify the stars and rewards on the dashboard
    Given User navigates to the Starbucks login page
    When User enters valid username and password
    And User should be redirected to the dashboard
    Then User verify the dashboard stars and rewards

#  Scenario: Login with empty fields
#    Given User navigates to the Starbucks login page
#    Then User should see an error message indicating that fields cannot be empty