Feature: OrangeHRM User Login

  Scenario: Successful login with valid credentials
    Given the user is on the OrangeHRM login page
    When the user enters a valid username and password
    Then the user should be redirected to the OrangeHRM dashboard

  Scenario: Add a new user
    Given the application is open and user is logged in
    When the Admin section is accessed
    And the Add button is clicked
    And user details are entered
    And the Save button is clicked
    Then the new user should appear in the user list

  Scenario: Search for an existing user
    Given user is logged in to search for a user
    When the user is searched
    Then the user should be visible in the search results

  Scenario: Edit user status
    Given user is logged in to edit user status
    When the user status is edited
    Then the updated status should be reflected

  Scenario: Delete an existing user
    Given user is logged in to delete a user
    When the user is deleted
    Then the user should no longer appear in the list
