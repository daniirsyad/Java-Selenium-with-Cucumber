Feature: Login

  Scenario: Login Success
    Given Open web url "https://www.saucedemo.com"
    Then User input "standard_user" in field Username
    And User input "secret_sauce" in field Password
    Then User click Login Button
    Then User redirected to "https://www.saucedemo.com/inventory.html"


  Scenario: Login Failed
    Given Open web url "https://www.saucedemo.com"
    Then User input 'blabla_user' in field Username
    And User input '123123' in field Password
    Then User click Login Button
    Then User get error 'Epic sadface: Username and password do not match any user in this service'