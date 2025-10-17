Feature: OrangeHRM Admin Dashboard

  Scenario: functionality check of admin button
    Given the user is on the dashboard
    When the user clicks on the Admin button
    Then the user should be redirected to the Admin page
