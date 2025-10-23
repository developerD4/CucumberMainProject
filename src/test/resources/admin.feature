Feature: Admin Page

  Scenario: Add a new user
    Given the application is open and user is logged in
    When the Admin section is accessed
    And the Add button is clicked
    And user details are entered 
    And the Save button is clicked
    Then the new user should appear in the user list

  