package screens

import elements.LoginElements
import elements.LoginElements.emailInput
import elements.LoginElements.forgotPasswordLink
import elements.LoginElements.loginButton
import elements.LoginElements.passwordInput
import elements.LoginElements.socialMediaFacebookContinueDialog
import elements.SocialMediaElements.facebookAllowCookiesButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import utilities.DriverKeyboardHandler
import utilities.JsonObject
import utilities.scrollTo

class LoginScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), LoginElements)
    }

    fun tapOnEmailInput() {
        waitUntilElementVisible(emailInput)
        emailInput.click()
    }

    fun enterEmail(userType: String) {
        val jsonObject = JsonObject()
        when (userType) {
            "User with less than 5 favourites" -> {
                emailInput.sendKeys(jsonObject.getEmailAddress("Plus in Address", userType))
            }
            "Valid User", "Unregistered Email", "Invalid Password" -> {
                emailInput.sendKeys(jsonObject.getEmailAddress("Dot in Address", userType))
            }
            "Valid Balance User" -> {
                emailInput.sendKeys(jsonObject.getEmailAddress("Balance Email", userType))
            }
            else -> {
                emailInput.sendKeys(jsonObject.getEmailAddress("Missing Address", userType))
            }
        }
    }

    fun signInUsingFacebook() {
        scrollTo(driver, "facebook_txt")
        LoginElements.socialMediaFacebookLink.click()
    }

    fun signInUsingApple() {
        if (driver is IOSDriver) {
            scrollTo(driver, "facebook_txt")
            LoginElements.socialMediaAppleLink.click()
        }
    }

    fun signInUsingPaypal() {
        scrollTo(driver, "paypal_button")
        LoginElements.socialMediaPaypalLink.click()
    }

    fun enterPassword(userType: String) {
        val jsonObject = JsonObject()
        when (userType) {
            "Valid User", "Unregistered Email", "Invalid Email", "User with less than 5 favourites" -> {
                passwordInput.sendKeys(jsonObject.getPassword("Simple Password", userType))
            }
            "Valid Balance User" -> {
                passwordInput.sendKeys(jsonObject.getPassword("Balance Password", userType))
            }
            else -> {
                passwordInput.sendKeys(jsonObject.getPassword("Invalid Password", userType))
            }
        }
    }

    fun tapSignInButton() {
        DriverKeyboardHandler.hideSecondKeyboard(driver)
        if (driver is IOSDriver) {
            loginButton.click()
        }
    }

    fun clickForgotPasswordLink() {
        waitUntilElementVisible(forgotPasswordLink)
        forgotPasswordLink.click()
    }

}