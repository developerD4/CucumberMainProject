Feature: OrangeHRM Admin - Add User

  Scenario: Successful addition of a user
    Given the user is on the Admin page
    When the user clicks on the add button
    And the user selects a user role
    And the user enters the employee name
    And the user selects a status
    And the user enters a username    
    And the user enters a password
    And the user confirms the password
    And the user clicks on the save button
    Then the user should be redirected back to the Admin page
