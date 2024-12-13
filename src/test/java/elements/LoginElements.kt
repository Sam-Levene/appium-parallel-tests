package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object LoginElements {

    @AndroidFindBy(id = "signin_email_edittext")
    @iOSXCUITFindBy(accessibility = "email_text_field")
    lateinit var emailInput: WebElement

    @AndroidFindBy(id = "signin_password_edittext")
    @iOSXCUITFindBy(accessibility = "password_text_field")
    lateinit var passwordInput: WebElement

    @AndroidFindBy(id = "signin_button")
    @iOSXCUITFindBy(accessibility = "sign_in_button")
    lateinit var loginButton: WebElement

    @AndroidFindBy(id = "login_forgotten_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Forgot password?\"]")
    lateinit var forgotPasswordLink: WebElement

    @AndroidFindBy(id = "facebook_sign_in_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue with Facebook\"]")
    lateinit var socialMediaFacebookLink: WebElement

    @AndroidFindBy(id = "paypal_sign_in_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue with PayPal\"]")
    lateinit var socialMediaPaypalLink: WebElement

    @AndroidFindBy(id = "apple_sign_in_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue with Apple\"]")
    lateinit var socialMediaAppleLink: WebElement

    @iOSXCUITFindBy(accessibility = "Continue")
    lateinit var socialMediaFacebookContinueDialog: WebElement

    @iOSXCUITFindBy(accessibility = "Close")
    lateinit var socialMediaAppleCloseDialog: WebElement
}