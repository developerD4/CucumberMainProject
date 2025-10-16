@ThirdSearch
Feature: Search User


  Scenario: Search for an existing user
    Given user is logged in to search for a user
    When the user is searched
    Then the user should be visible in the search results
