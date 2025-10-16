@FirstLogin
Feature: OrangeHRM User Login
  
  Scenario: Successful login with valid credentials
    Given the user is on the OrangeHRM login page
    When the user enters a valid username and password
    Then the user should be redirected to the OrangeHRM dashboard
