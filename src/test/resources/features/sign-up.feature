@user-registration
Feature: New user registration.

  As a guest user who is NOT registered with Quidco
  I can create an account using the Quidco mobile app
  So that I can become a member and take advantage of cashback offers on Quidco.

  Scenario: Can sign up with "New User" credentials
    Given a "New User" is not logged in
    When "New User" enters their credentials
    And the user skips notifications and permissions
    Then "New User" is logged into the app

  Scenario Outline: Cannot sign up with invalid credentials
    Given a "<Invalid User Type>" is not logged in
    When "<Invalid User Type>" enters their credentials
    Then the related warning "<Warning>" is displayed
    Examples:

      | Invalid User Type | Warning                                                                         |
      | Invalid Email     | Email formatting is incorrect                                                   |
      | Invalid Password  | Password must be 8 characters including at least 1 uppercase letter and number  |

  Scenario: New Users details are correct
    Given "New User" has just registered
    When the user skips notifications and permissions
    When the user taps on the "Settings" button in the app footer
    Then "New User" details are correct

  Scenario: Can sign up with marketing
    Given a "New user" is not logged in
    When "New User" enters their credentials with Marketing consent accepted
    And the user skips notifications and permissions
    Then "New User" marketing consent is accepted

  Scenario: User already exists
    Given a "Valid User" is not logged in
    When "Valid User" enters their credentials
    Then  The "This email address is already registered. Please sign in." warning is displayed

  Scenario: Sign up from refer a friend
    Given a "Referred User" is not logged in
    When "Referred User" enters their credentials
    And the "Referred User" sign up link is used
    And the user skips notifications and permissions
    Then "Referred User" is logged into the app
