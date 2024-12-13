@favourites @Skip
Feature: User navigates to the new favourites screen

  As an existing Quidco member
  I can navigate to my favourites page
  So that I can see and edit all of my favourite merchants

  Scenario: Any user opens the favourites screen
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    Then the app displays the Favourites screen

  Scenario: User has no favourites
    Given "New User" has just registered
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    Then the screen shows content to prompt the user to add favourites

  Scenario: User has more than one favourite but less than five
    Given a "User with less than 5 favourites" is not logged in
    When a "User with less than 5 favourites" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    Then the screen shows content to prompt the user to add more favourites

  Scenario: User has 5 or more favourites
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    Then the app displays the Favourites screen

  Scenario: User adds a favourite
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    And the user "adds a favourite to" their list of favourites
    Then the number of favourites is increased by one

  Scenario: User cancels the favourites screen
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    And the user "adds a favourite to" their list of favourites
    And the user cancels their journey
    Then the user is returned to the Favourites Screen

  Scenario: User removes a favourite
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    And the user "removes a favourite from" their list of favourites
    Then the number of favourites is decreased by one

  Scenario Outline: User searches for a favourite
    Given a "Valid User" is not logged in
    When a "Valid User" signs in at the start
    And the user skips notifications and permissions
    When the user taps on the "Favourites" button in the app footer
    And the user searches for a "<FavouriteType>"
    Then the favourite search results "<ResultsDisplayed>" displayed
    Examples:
    | FavouriteType   | ResultsDisplayed  |
    | Valid Search    | are               |
    | Invalid Search  | are not           |

  Scenario Outline: Invalid user type cannot see favourites
    Given a "<UserType>" is not logged in
    When a "<UserType>" signs in at the start
    And the user skips notifications and permissions
    Then the user is not logged in and cannot access favourites
    Examples:
    | UserType            |
    | Invalid Password    |
    | Unregistered Email  |
    | Invalid Email       |
    | Guest User          |
