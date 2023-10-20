Feature: Checkout

  Scenario: User successfully checkout an item
    Given User is logged in with username 'standard_user' and password 'secret_sauce'
    Then User click Add to cart for 2 items
    Then User click basket button on the right top
    Then User click 'Checkout'
    Then User input 'daanii' in the 'first-name' field
    And User input 'irsyaad' in the 'last-name' field
    And User input '123' in the 'postal-code' field
    Then User click Continue button
    Then User click 'Finish'
    Then User click 'Back Home'