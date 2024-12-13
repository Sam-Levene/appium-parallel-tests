@merchant
Feature: Merchant profile

  As an existing Quidco member
  I can clickout from a merchant page
  So that I can earn cashback.

  Scenario Outline: Signed in user performs a clickout from a merchant
    Given A "<UserType>" signs in
    When the user skips notifications and permissions
    And the user searches for "Argos"
    And I see the merchant page has loaded
    And I tap on the main CTA
#    blocked by cloudflare
#    Then I go to the Argos website
  Examples:
    | UserType    |
    | Valid User  |