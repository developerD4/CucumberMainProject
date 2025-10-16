Feature: Edit User

  Scenario: Edit user status
    Given user is logged in to edit user status
    When the user status is edited
    Then the updated status should be reflected