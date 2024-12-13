@intercom
Feature: Third Party Applications: Intercom

  As an existing Quidco member
  I can get help from Quidco if I have a problem with the application
  So that I can resolve any issues or queries that I may have

  Scenario: A user logs in and attempts to contact support for assistance
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Support" button in the app footer
    Then the support page is visible