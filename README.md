# Appium Parallel Tests

This Appium test pack is intended to be used as an automation tool to aid developers and testers in identifying regressions in the Quidco app. 

## Table of contents

[TOC]

## How to set up Appium

Appium is set up in the command line using the following method:

```
npm install -g appium@next

npm config set registry https://registry.npmjs.org/
npm cache clear --force
appium driver install xcuitest
appium driver install uiautomator2
```

## Test Execution

Make sure Appium is running. If running locally, it is strongly recommended that Appium is executed like so:
```
appium server -p 4723 -a 127.0.0.1 -pa /wd/hub
```

Once Appium has started the automation framework can be triggered with the following command:
```
export OS=iOS env=Dev IOS_DEVICE=iPhone\ 11 URL=http://127.0.0.1:4723/wd/hub && ./gradlew cucumber
export OS=iOS env=Dev IOS_DEVICE=iPhone\ 11 URL=http://127.0.0.1:4723/wd/hub && ./gradlew cucumber -Ptags="@login"

or

env=Dev;ANDROID_DEVICE=Google Pixel 5;OS=Android;URL=http://127.0.0.1:4723/wd/hub ./gradlew cucumber
```

There are ways to get the Test Automation suite operational on a virtual emulated device on your machine. 
This is especially useful if you are struggling to connect a device or do not have a device to connect.
In order to do this, a good starting place is to have a look at the https://quidco.atlassian.net/wiki/spaces/QA/pages/3424944141/Running+the+tests+in+the+appium+repo link

The environment variables are being used to configure which device is being tested, and as such, need to be edited in the edit Run Configurations:
```
OS = iOS
URL = 127.0.0.1:4723/wd/hub
env = Dev
IOS_DEVICE = iPhone 14
(Optional) Ticket = [middlelayer-ticket]

OS = Android
URL = 127.0.0.1:4723/wd/hub
env = Dev
ANDROID_DEVICE = Google Pixel 5
(Optional) Ticket = [middlelayer-ticket]
```

## Project Structure

```
.
├── .gitignore
├── build.gradle
├── email-addresses.json
├── gradlew
├── gradlew.bat
├── passwords.json
├── README.md
├── settings.gradle
└── src
   └── test
       ├── java
       │   ├── cucumber
       │   │   ├── runners
       │   │   │   └── BaseTest.kt
       │   │   └── stepdefs
       │   │       ├── BaseSteps.kt
       │   │       ├── LoginSteps.kt
       │   │       ├── MerchantProfileSteps.kt
       │   │       ├── MiscSteps.kt
       │   │       ├── SearchSteps.kt
       │   │       └── SignUpSteps.java
       │   ├── elements
       │   │   ├── AccountElements.kt
       │   │   ├── EntryElements.kt
       │   │   ├── ForgotPasswordElements.kt
       │   │   ├── IntercomElements.kt
       │   │   ├── JoinUsOrSignInElements.kt
       │   │   ├── LoginElements.kt
       │   │   ├── MerchantProfileElements.kt
       │   │   ├── NavElements.kt
       │   │   ├── NotificationsElements.kt
       │   │   ├── SearchElements.kt
       │   │   ├── SettingsElements.kt
       │   │   ├── SignedInHomeElements.kt
       │   │   ├── SignedOutHomeElements.kt
       │   │   ├── SignUpElements.kt
       │   │   ├── SocialMediaElements.kt
       │   │   └── SupportElements.kt
       │   ├── screens
       │   │   ├── AccountScreen.kt
       │   │   ├── BaseScreen.kt
       │   │   ├── EntryScreen.kt
       │   │   ├── ForgotPasswordScreen.kt
       │   │   ├── IntercomScreen.kt
       │   │   ├── JoinUsOrSignInScreen.kt
       │   │   ├── LoginScreen.kt
       │   │   ├── MerchantProfileScreen.kt
       │   │   ├── NavScreen.kt
       │   │   ├── NotificationsPermission.kt
       │   │   ├── SearchScreen.kt
       │   │   ├── SettingsScreen.kt
       │   │   ├── SignedInHomeScreen.kt
       │   │   ├── SignedOutHomeScreen.kt
       │   │   ├── SignUpScreen.kt
       │   │   ├── SocialMediaScreen.kt
       │   │   └── SupportScreen.kt
       │   └── utilities
       │       ├── DesiredCapabilitiesUtil.kt
       │       ├── DriverKeyboardHandler.kt
       │       ├── Find.kt
       │       ├── JsonObject.kt
       │       └── ThreadLocalDriver.kt  
       └── resources
           ├── features
           │   ├── intercom.feature
           │   ├── login.feature
           │   ├── merchant.feature
           │   ├── sign-up.feature
           │   └── withdrawl.feature 
           ├── cucumber.properties
           ├── junit-platform.properties
           └── log4j.properties

```

## Writing a New Test

1. Create a feature file (i.e. "Given, When, Then", or "GWT" for short) in the `src/test/resources/features`.
2. Each step within a feature file is implemented in a step definition file in `src/test/java/stepdefs`.
3. Implement the main logic in a "screen" file in `src/test/java/screens` and the elements in an "elements" file in `src/test/java/elements`.

### Helpers

Helpers for "screens" reside in `src/test/java/screens/BaseScreen.kt`.

### Writing StepDef Files

Each stepdef file should extend `BaseSteps`. This will provide an instance to the driver that
is threadsafe (i.e. for the current running thread). The driver is available via the `driver`
variable.

### Writing Screen Files

The [Page Object Model design pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) is used to implement screens. 
Both the element locators and functionality that can be performed on a screen are included in the same
screen file (for simplicity). An example:
```kotlin
class LoginScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), LoginElements)
    }

    fun tapOnEmailInput() {/*...*/}
}
```

**IMPORTANT:** You need to include a constructor that calls `PageFactory.initElements` in all screen files.

### Using Step Definition Files

Simply instantiate step files passing an instance to the driver. It's  handy to simply
instantiate any drivers you use at the top of your step definition files. To obtain an instance of the driver:
```kotlin
  private val loginScreen = LoginScreen(driver)
```

Whenever possible, use the "Resource ID" to locate elements. For example, the Inspector might show a
resource-id like `com.quidco.staging:id/monthly_bonus_layout`. This would look like this in a screen file:
```kotlin
@AndroidFindBy(id = "monthly_bonus_layout")
@iOSXCUITFindBy(accessibility = "monthly_bonus_layout")
lateinit var monthlyBonusBanner: WebElement
```
