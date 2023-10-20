Feature: Reset Cart

  Scenario: Reset Added Cart
    Given User is logged in with username 'standard_user' and password 'secret_sauce'
    Then User click Add to cart for 2 items
    Then User click menu button
    Then User click Reset App State
    Then User click basket button on the right top
    Then Cart is empty