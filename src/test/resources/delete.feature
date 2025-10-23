Feature: Delete User

  Scenario: Delete an existing user
    Given user is logged in to delete a user
    When the user is deleted
    Then the user should no longer appear in the list