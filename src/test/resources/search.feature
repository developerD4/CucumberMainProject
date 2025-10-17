Feature: OrangeHRM User Management - Search Functionality

  Scenario: Verify that the search button works and keeps the user on the same page
    Given the user is on the Admin page
    When the user enters the Username, selects a User Role, enters the Employee Name, selects a Status, and clicks on the Search button
    Then the user remains on the Admin page and search results are displayed
