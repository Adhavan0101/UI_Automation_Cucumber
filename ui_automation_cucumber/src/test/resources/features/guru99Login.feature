@login
Feature: The login feature for guru99 website

  Scenario: This is the login scenario
    Given The user is on login pages
    When The user enters valid username & Password
    And The user Clicks on the login buttons
    And The user should be navigated to home pages
    Then The webpages should be closed
