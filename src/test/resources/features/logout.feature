Feature: Logout

  Scenario: Logout Success
    Given User is logged in with username 'standard_user' and password 'secret_sauce'
    Then User click menu button
    Then User click logout
    Then User is redirected to login page 'https://www.saucedemo.com/'