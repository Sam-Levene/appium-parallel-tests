@login
Feature: Sign in to the app from the signed-out home screen.

  As an existing Quidco member
  I can sign in to my Quidco account using the Quidco mobile app
  So that I can take advantage of cashback offers on Quidco.

  Scenario Outline: Sign in to the app from the signed-out home screen
    Given a "<UserType>" is not logged in
    When a "<UserType>" signs in at the start
    And the user skips notifications and permissions
    Then The signed in home screen "<Visibility>" visible
    Examples:
    | UserType            | Visibility  |
    | Valid User          | Is          |
    | Invalid Password    | Is not      |
    | Unregistered Email  | Is not      |
    | Invalid Email       | Is not      |

  Scenario Outline: Use the forgotten password function to send a reminder email
    Given a "<UserType>" is not logged in
    When the user selects forgotten password
    And "<UserType>" enters their Email
    Then message is displayed
    And email "<Validation>" sent
    Examples:
    | UserType            | Validation  |
    | Valid User          | Is          |
    | Unregistered Email  | Is Not      |

  Scenario Outline: User signs in from a page and can return to that page
    Given A guest visits the site
    When the guest navigates to the "<UserPage>"
    And the guest signs in as a "<UserType>"
    And the user skips notifications and permissions
    Then the user is signed in at the "<UserPage>"
    Examples:
    | UserPage        | UserType      |
    | Home Page       | Valid User    |
    | Refer a Friend  | Valid User    |
    | Merchant Page   | Valid User    |
    | Home Page       | Invalid User  |
    | Refer a Friend  | Invalid User  |
    | Merchant Page   | Invalid User  |

  Scenario Outline:  User signs in using social media sign-on (SSO)
    Given a "Valid User" is not logged in
    When the user signs in using the "<SocialMediaType>" social media link
    And the user skips notifications and permissions
    Then The signed in home screen "Is" visible
    Examples:
    | SocialMediaType |
    | Facebook        |
#    | Apple           |
    | Paypal          |
